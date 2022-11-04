package br.edu.iftm.workspace.service;

import br.edu.iftm.workspace.dto.Access;
import br.edu.iftm.workspace.entity.Collaborator;
import br.edu.iftm.workspace.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorBaseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService userService;

    public Collaborator save(String spaceId, String userId, Access access) {
        User user = userService.findById(userId);
        Collaborator collaborator = new Collaborator(user, access);
        Update update = new Update();
        update.push("collaboratorList", collaborator);
        Criteria criteria = Criteria.where("_id").is(spaceId);
        mongoTemplate.updateFirst(Query.query(criteria), update, "base");
        return collaborator;
    }
}
