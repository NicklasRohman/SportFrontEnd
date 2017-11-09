package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.sportsing.api.ContenderResult;

	@XmlRootElement
	public class MatchResult implements Serializable{
		private static final long serialVersionUID = 1L;

		@XmlElement
		private String sport;

		@XmlElementWrapper(name="contenders")
		@XmlElement(name="contender")
		private List<ContenderResult> contenders;

		public MatchResult() {}
		
		public MatchResult(String sport) {//,String name,int score,int place
			this.sport = sport;
			contenders = new ArrayList<ContenderResult>();
			//registerContender(name, score, place);
		}
		public void registerContender(ContenderResult cr) {
			contenders.add(cr);
		}
		public void registerContender(String name, float score, int place) {
			registerContender(new ContenderResult(name, score, place));
		}

		public Iterator<ContenderResult> getContenderIterator() {
			return contenders.iterator();
		}

}