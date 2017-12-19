package date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateManipulations {

	public static void main(String[] args) {

		Timestamp endDt = Timestamp.from(Instant.now());
//		endDt = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date eDate = (null == endDt)? null : new Date(endDt.getTime());

		String endDate = (null == eDate)? "" : sdf.format(eDate);
		
		System.out.println(endDate);

	}

}
