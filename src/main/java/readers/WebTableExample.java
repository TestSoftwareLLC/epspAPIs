package readers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.Configuration;

public class WebTableExample extends Configuration
{

	public static void main(String[] args) {
		WebDriver driver = new InternetExplorerDriver();
		driver.get(HOST);

		WebElement table_element = driver.findElement(By.id(TABLEID));
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('testTable')/tbody/tr"));

		System.out.println("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
		int row_num, col_num;
		row_num = 1;
		for (WebElement trElement : tr_collection) {
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
			System.out.println("NUMBER OF COLUMNS=" + td_collection.size());
			col_num = 1;
			for (WebElement tdElement : td_collection) {
				System.out.println("row # " + row_num + ", col # " + col_num + "text=" + tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}
}