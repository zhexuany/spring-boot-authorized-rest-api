package edu.global.sgs.hander;

import edu.global.sgs.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static edu.global.sgs.hander.WebSocketBrokerConfig.MESSAGE_PREFIX;

@Component
@RepositoryEventHandler(Course.class)
public class CourseEventHandler {
    
    private final SimpMessagingTemplate websocket;

    private final EntityLinks entityLinks;

    @Autowired
    public CourseEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newCourse(Course Course) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/newCourse", getPath(Course));
    }

    @HandleAfterDelete
    public void deleteCourse(Course Course) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/deleteCourse", getPath(Course));
    }

    @HandleAfterSave
    public void updateCourse(Course Course) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/updateCourse", getPath(Course));
    }

    /**
     * Take an {@link Course} and get the URI using Spring Data REST's {@link EntityLinks}.
     *
     * @param Course
     */
    private String getPath(Course Course) {
        return this.entityLinks.linkForSingleResource(Course.getClass(),
                Course.getId()).toUri().getPath();
    }
}
