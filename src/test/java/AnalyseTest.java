import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cell.service.RiskAnalyseService;
import com.cell.viewmodel.RiskAnalyseModel;

public class AnalyseTest {

	@Autowired
    private RiskAnalyseService riskAnalyseService;
	private List<RiskAnalyseModel> acknowledged;
	private List<RiskAnalyseModel> troubled;
	@Test
	public void test() {
//		riskAnalyseService()
		Date endDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar date = Calendar.getInstance();
		date.setTime(endDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 7);
		System.out.println(sdf.format(date.getTime()));
		Date startDate = new Date();
		try {
			startDate = sdf.parse(sdf.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(startDate+" - "+endDate);
		acknowledged = riskAnalyseService.getTop5AcknowledgedRisks(startDate, endDate);
		troubled = riskAnalyseService.getTop5TroubledRisks(startDate, endDate);
		if(acknowledged.isEmpty())System.out.println("空");
		else System.out.println(acknowledged.get(0).getCount());
	}

}
