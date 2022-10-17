package br.edu.iftm.workspace.repository;

import br.edu.iftm.workspace.entity.CollaboratorWorkspace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceCollaboratorRepository extends MongoRepository<CollaboratorWorkspace, String> {
}
