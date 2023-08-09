import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

resp1 = WS.sendRequest(findTestObject('ReqResCollection/Postman/Requests/List User', [('reqresURL') : GlobalVariable.reqresURL]))

WS.verifyResponseStatusCode(resp1, 200)

WS.verifyElementPropertyValue(resp1, 'data[1].first_name', 'Lindsay')

println('first request executed')

resp2 = WS.sendRequest(findTestObject('ReqResCollection/Postman/Requests/Single User', [('local_url') : GlobalVariable.local_url]))

println('second request executed')

not_run: WS.verifyResponseStatusCode(resp2, 200)

if (WS.getResponseStatusCode(resp2) == 200) {
    WS.sendRequest(findTestObject('ReqResCollection/Postman/Requests/Single User Not Found', [('reqresURL') : GlobalVariable.reqresURL]))

    println('third request executed')
}

