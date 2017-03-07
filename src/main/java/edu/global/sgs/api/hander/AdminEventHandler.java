package edu.global.sgs.api.hander;

import edu.global.sgs.api.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Admin.class)
public class AdminEventHandler {
    private final SimpMessagingTemplate websocket;

    private final EntityLinks entityLinks;

    @Autowired
    public AdminEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newAdmin(Admin admin) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/newAdmin", getPath(admin));
    }

    @HandleAfterDelete
    public void deleteAdmin(Admin admin) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/deleteAdmin", getPath(admin));
    }

    @HandleAfterSave
    public void updateAdmin(Admin admin) {
        this.websocket.convertAndSend(
                WebSocketBrokerConfig.MESSAGE_PREFIX + "/updateAdmin", getPath(admin));
    }

    /**
     * Take an {@link Admin} and get the URI using Spring Data REST's {@link EntityLinks}.
     *
     * @param admin
     */
    private String getPath(Admin admin) {
        return this.entityLinks.linkForSingleResource(admin.getClass(),
                admin.getId()).toUri().getPath();
    }
}
