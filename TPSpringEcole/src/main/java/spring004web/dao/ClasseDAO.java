package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import spring004web.bean.Classe;
import spring004web.bean.Prof;

@Repository
public class ClasseDAO implements IClasseDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Classe> rechercherClasses() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Classe> lCriteriaQuery = lCriteriaBuilder.createQuery(Classe.class);
		final Root<Classe> lRoot = lCriteriaQuery.from(Classe.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Classe> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypedQuery.getResultList();
	}

	public Classe rechercherClasseId(Integer pId) {
		List<Classe> lProfs = rechercherClasses();
		for (Classe prof : lProfs) {
			if (prof.getId().equals(pId))
				return prof;
		}
		return null;
	}

	public void creerClasse(Classe pClasse) {
		entityManager.persist(pClasse);
	}

	public void supprimerClasse(Classe pClasse) {
		final Classe lClasse = entityManager.getReference(Classe.class, pClasse.getId());
		entityManager.remove(lClasse);
	}

	public void modifierClasse(Classe pClasse) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Classe> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Classe.class);
		final Root<Classe> lRoot = lCriteriaUpdate.from(Classe.class);
		final Path<Classe> lPath = lRoot.get("id");
		System.err.println("id :" + pClasse.getId());
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pClasse.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("nom", pClasse.getNom());
		lCriteriaUpdate.set("prenom", pClasse.getProf());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			System.err.println(lRowCount);
		}
	}

}
