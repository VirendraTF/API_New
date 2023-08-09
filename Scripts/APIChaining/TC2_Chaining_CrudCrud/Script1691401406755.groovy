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

resp1 = WS.sendRequest(findTestObject('Postman_CrudCrud - Copy/create Unicorn'))

def resp_id = WS.getElementPropertyValue(resp1, '_id')

println('.......id of entity : ' + resp_id)

GlobalVariable.id_crud = resp_id

println('.........new values of GlobalVariable :' + GlobalVariable.id_crud)

resp2 = WS.sendRequest(findTestObject('Postman_CrudCrud - Copy/Get Single Unicorn'))

println(WS.getResponseStatusCode(resp2))

'print colour and age'
println((('--> colour of unicorn : ' + WS.getElementPropertyValue(resp2, 'colour')) + ' &  Age of Unicorn : ') + WS.getElementPropertyValue(
        resp2, 'age'))


WS.sendRequest(findTestObject('Postman_CrudCrud - Copy/Update Unicorn', [('IdLocal') : GlobalVariable.id_crud]))

resp3 = WS.sendRequest(findTestObject('Postman_CrudCrud - Copy/Get Single Unicorn'))

'print colour and age'
println(((' --> Updated colour of unicorn : ' + WS.getElementPropertyValue(resp3, 'colour')) + ' &  Age of Unicorn : ') + WS.getElementPropertyValue(
        resp3, 'age'))

println(WS.getResponseStatusCode(resp3))

