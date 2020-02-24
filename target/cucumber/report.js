$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/transfer/selfTransfer/SelfTransfer.feature");
formatter.feature({
  "name": "SelfTransfer",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Make Self Transfer",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigates to ncb \"\u003curl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User  clicks on button headerLanguage",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid company \"\u003ccompany\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid user  \"\u003cuser\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User enters a valid password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on button",
  "keyword": "When "
});
formatter.step({
  "name": "User should be taken to the dashboard \u003clistOfMenusAtDashBoard\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "User clicks on menu transfer at dashboard",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer menu sub page",
  "keyword": "Then "
});
formatter.step({
  "name": "User clicks on menu transfer at dashboard",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer page transfersHome",
  "keyword": "Then "
});
formatter.step({
  "name": "User clicks on menu Self transfer",
  "keyword": "And "
});
formatter.step({
  "name": "User click at selector AccountFrom",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the Account from selector",
  "keyword": "Then "
});
formatter.step({
  "name": "User Selected \"\u003cAccountFromNumber\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer page with account to selected available to selected",
  "keyword": "Then "
});
formatter.step({
  "name": "User click at selector Account To",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the Account To selector",
  "keyword": "Then "
});
formatter.step({
  "name": "User Selected \"\u003cAccountToNumber\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer page",
  "keyword": "Then "
});
formatter.step({
  "name": "User add amount \"\u003camountInput\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User add instructions \"\u003cinstructionsInput\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Click at Proceed Button",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer confirm page",
  "keyword": "Then "
});
formatter.step({
  "name": "User add \"\u003cOTP\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer result page",
  "keyword": "Then "
});
formatter.step({
  "name": "User click at button Finish",
  "keyword": "And "
});
formatter.step({
  "name": "User should be taken to the transfer home page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "url",
        "company",
        "user",
        "password",
        "listOfMenusAtDashBoard",
        "AccountFromNumber",
        "AccountToNumber",
        "amountInput",
        "instructionsInput",
        "OTP"
      ]
    },
    {
      "cells": [
        "http://dev.innofis.local:8100/#/login/login-login",
        "abahusain",
        "transferUser",
        "abcd1234",
        "listOfMenusAtDashBoard",
        "05100000124510",
        "05100000249905",
        "50",
        "instructions",
        "1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Make Self Transfer",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigates to ncb \"http://dev.innofis.local:8100/#/login/login-login\"",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User  clicks on button headerLanguage",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters a valid company \"abahusain\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters a valid user  \"transferUser\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters a valid password \"abcd1234\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks on button",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the dashboard listOfMenusAtDashBoard",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks on menu transfer at dashboard",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer menu sub page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks on menu transfer at dashboard",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer page transfersHome",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks on menu Self transfer",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User click at selector AccountFrom",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the Account from selector",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User Selected \"05100000124510\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer page with account to selected available to selected",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User click at selector Account To",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the Account To selector",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User Selected \"05100000249905\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User add amount \"50\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User add instructions \"instructions\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Click at Proceed Button",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer confirm page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User add \"1234\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer result page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User click at button Finish",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should be taken to the transfer home page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});