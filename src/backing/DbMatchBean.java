package backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import com.sportsing.api.DbMatch;

@Named
@ViewScoped
public class DbMatchBean implements Serializable{
	private static final long serialVersionUID = 1L;

	List<DbMatch> dbmatchResult = new ArrayList<>();
	
	public List<DbMatch> getDbMatchResult() {

		WebTarget matchTarget = ClientBuilder.newClient()
				.target("http://localhost:8080/sportsing-webservice/rs/sports/dataBaseMatches");

		dbmatchResult = matchTarget.request(MediaType.APPLICATION_XML).get(new GenericType<List<DbMatch>>() {
		});

		return dbmatchResult;
	}
}
