package pomonitor.test;



import pomonitor.briefing.DocumentHandler;
import pomonitor.statistics.BriefingSummarize;

public class TestBriefingSummarize 
{

	public static void main(String[] args) {
		
          BriefingSummarize briefingSummarize=new BriefingSummarize();
          System.out.println(briefingSummarize.getPreviewChart1("568,999,1071,1563,2041"));
		 
	}

}
