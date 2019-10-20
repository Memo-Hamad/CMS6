package main.jpa.repository;

import java.sql.SQLException;

import java.sql.Timestamp;
import java.util.List;

import main.jpa.entity.*;


public interface IDeclarationRepository {



    public abstract List<DeclarationEntity> getDeclarations();
    public abstract DeclarationEntity getDeclaration(int decId);
    public abstract DeclarationEntity addDeclaration(DeclarationEntity declaration);
    public abstract void updateDeclaration(DeclarationEntity declaration);
    public abstract DeclarationEntity searchDeclarations(DeclarationTypeEntity decType, int decId,DeclarationStatusEntity decStatus, Timestamp decSubmittedOn,
                                                         PortEntity decPortType,AgentEntity decAgentId);
    public void insertTestData();

}