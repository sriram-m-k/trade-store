package com.test.cib.commons.data.mapper;

public interface IMapper<Model,Entity> {

	public Model getModelFromEntity(Entity entity);

	public Entity getEntityFromModel(Model model);
}
