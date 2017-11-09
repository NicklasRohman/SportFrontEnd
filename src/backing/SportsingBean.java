package backing;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.sportsing.api.Match;
import entities.MatchResult;
import facades.MatchResultFacade;

@Named
@ViewScoped
public class SportsingBean {

	@EJB
	private MatchResultFacade matchEJB;

	public void updateMatchResult() {
		WebTarget matchTarget = ClientBuilder.newClient()
				.target("http://localhost:8080/sportsing-webservice/rs/sports/");

		for (MatchResult m : matchEJB.findAll()) {
			WebTarget target = matchTarget.path("get/" + m.getContenderIterator());
			Match webServiceMatch = target.request(MediaType.APPLICATION_XML).get(Match.class);
			webServiceMatch.registerContender("Nicklas", 1, 3);
			matchEJB.edit(m);
		}
	}
}
