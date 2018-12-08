/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.swingcient;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solent.ac.uk.ood.examples.model.Entity;
import solent.ac.uk.ood.examples.model.EntityDAO;

/**
 *
 * @author cgallen
 */
public class ModelControllerImpl implements ModelController {

    private static final Logger LOG = LoggerFactory.getLogger(ModelControllerImpl.class);

    private EntityDAO entityDAO = null;
    
    private EntityListTableModel entityListTableModel = new EntityListTableModel();

   
    public ModelControllerImpl(EntityDAO entityDAO){
        this.entityDAO=entityDAO;
        List<Entity> entities = entityDAO.retrieveAllEntities();
        entityListTableModel.setEntities(entities);
    }


    @Override
    public EntityListTableModel getEntityListTableModel() {
        return entityListTableModel;
    }
    


    @Override
    public void clearSearch() {
        LOG.debug("clear search selected");
        
        List<Entity> entities = entityDAO.retrieveAllEntities();
        entityListTableModel.setEntities(entities);
    }

    @Override
    public void findMatchingSearch(Entity templateEntity) {
        LOG.debug("find matching with templateEntity="+templateEntity);
        
        List<Entity> entities = entityDAO.retrieveMatchingEntities(templateEntity);
        LOG.debug("found "+entities.size() + " matching with templateEntity="+templateEntity);
        entityListTableModel.setEntities(entities);
        
    }


}
