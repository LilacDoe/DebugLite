package github.lilacdoe.debugger

fun selectDebugLiteTests(): String {
    /** Select desired tests to validate debugLite */
    val debugLiteTestList = listOf(
        // basic examples
        true to ::exampleDebugLiteWithMinimumParams,
        true to ::exampleDebugLiteWithLocation,
        true to ::exampleDebugLiteWithLogic,
        true to ::exampleDebugLiteWithLocationLogic,
        // practical examples
        true to ::exampleDebugLiteUsingIterationLimit,
        true to ::exampleDebugLiteUsingIterationLimitBroken
    )
    // init StringBuilder
    val validateDebugLite = StringBuilder()
    // Add enabled tests from dict for return
    for ((shouldTest, function) in debugLiteTestList) {
        if (shouldTest) {  // Changed from 'allowTest' to the variable from the loop
            validateDebugLite.append(function())
        }
    }
    return validateDebugLite.toString()
}

private fun exampleDebugLiteWithMinimumParams(): String {
    val errorSeverity = LogSeverity.LOG
    val errorMsg = "validated debugLite with required params"
    return debugLite(errorSeverity, errorMsg)
}

private fun exampleDebugLiteWithLocation(): String {
    val errorSeverity = LogSeverity.LOG
    val errorMsg = "validated debugLite with optional errorLocation param added"
    val errorLocation = "testDebugLiteWithLocation"
    return debugLite(errorSeverity, errorMsg, errorLocation)
}

private fun exampleDebugLiteWithLogic(): String {
    val errorSeverity = LogSeverity.LOG
    val errorMsg = "validated debugLite with optional errorLogic param"
    val errorLogic = "if x != y"
    return debugLite(errorSeverity, errorMsg, errorLogic)
}

private fun exampleDebugLiteWithLocationLogic(): String {
    val errorSeverity = LogSeverity.LOG
    val errorMsg = "validated debugLite with optional errorLocation and errorLogic params"
    val errorLocation = "testDebugLiteWithLocationLogic"
    val errorLogic = "if fictionalParam is null"
    return debugLite(errorSeverity, errorMsg, errorLocation, errorLogic)
}

private fun exampleDebugLiteUsingIterationLimit(): String {
    var count = 0
    val countLimit = 25
    val iterationLimit = 50
    while (true) {
        count++
        if (count > countLimit) {  // prevent infinite loop
            break
        }
        if (count > iterationLimit) {  // report infinite loop
            val errorSeverity = LogSeverity.ERROR
            val errorMsg = "this test was not supposed to report even when true"
            val errorLocation = "testDebugLiteUsingIterationLimit"
            val errorLogic = "if count > iterationLimit"
            return debugLite(errorSeverity, errorMsg, errorLocation, errorLogic)
        }
    }
    return ""
}

private fun exampleDebugLiteUsingIterationLimitBroken(): String {
    var count = 0
    val iterationLimit = 50
    while (true) {
        count++
        if (count > iterationLimit) {  // report infinite loop
            val errorSeverity = LogSeverity.NOTE
            val errorMsg = "the iterationLimit was reached as desired"
            val errorLocation = "testDebugLiteUsingIterationLimitBroken"
            val errorLogic = "if count > iterationLimit"
            return debugLite(errorSeverity, errorMsg, errorLocation, errorLogic)
        }
    }
}

fun main() {
    val output = selectDebugLiteTests()
    println(output)
}

/**
 *    Copyright 2023 LilacDoe (GitHub)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
