package edu.global.sgs.api.hander;

import edu.global.sgs.api.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Department.class)
public class DepartmentEventHandler {
    
    private final SimpMessagingTemplate websocket;

    private final EntityLinks entityLinks;

    @Autowired
    public DepartmentEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newDepartment(Department Department) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/newDepartment", getPath(Department));
    }

    @HandleAfterDelete
    public void deleteDepartment(Department Department) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/deleteDepartment", getPath(Department));
    }

    @HandleAfterSave
    public void updateDepartment(Department Department) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/updateDepartment", getPath(Department));
    }

    /**
     * Take an {@link Department} and get the URI using Spring Data REST's {@link EntityLinks}.
     *
     * @param Department
     */
    private String getPath(Department Department) {
        return this.entityLinks.linkForSingleResource(Department.getClass(),
                Department.getId()).toUri().getPath();
    }}
