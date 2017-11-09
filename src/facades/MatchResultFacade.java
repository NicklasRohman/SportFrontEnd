package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.MatchResult;

@Stateless
public class MatchResultFacade extends AbstractFacade<MatchResult>{
@PersistenceContext(unitName="Sports")
	private EntityManager em;

	public MatchResultFacade() {
		super(MatchResult.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}