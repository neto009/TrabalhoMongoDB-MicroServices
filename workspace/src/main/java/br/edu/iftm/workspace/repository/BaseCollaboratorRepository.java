package br.edu.iftm.workspace.repository;

import br.edu.iftm.workspace.entity.CollaboratorBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseCollaboratorRepository extends MongoRepository<CollaboratorBase, String> {
}
