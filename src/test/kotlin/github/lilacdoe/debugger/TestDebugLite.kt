package github.lilacdoe.debugger

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TestDebugLite {

    @Test
    fun testDebugLiteBasicParams() {
        val result = debugLite(LogSeverity.LOG, "This is a test log")
        assertTrue(result.contains(LogSeverity.LOG.toString()))
        assertTrue(result.contains("This is a test log"))
    }

    @Test
    fun testDebugLiteWithLocation() {
        val result = debugLite(LogSeverity.LOG, "This is a test log", "Main Function")
        assertTrue(result.contains("Main Function"))
    }

    @Test
    fun testDebugLiteWithLogic() {
        val result = debugLite(LogSeverity.LOG, "This is a test log", errorLogic = "x > y")
        assertTrue(result.contains("x > y"))
    }

    @Test
    fun testDebugLiteWithLocationAndLogic() {
        val result = debugLite(LogSeverity.LOG, "This is a test log", "Main Function", "x > y")
        assertTrue(result.contains("Main Function"))
        assertTrue(result.contains("x > y"))
    }

    @Test
    fun testDebugLiteWithNullLocation() {
        val result = debugLite(LogSeverity.LOG, "This is a test log", null)
        assertTrue(result.contains(LogSeverity.LOG.toString()))
        assertTrue(!result.contains("Location:"))
    }

    @Test
    fun testDebugLiteWithNullLogic() {
        val result = debugLite(LogSeverity.LOG, "This is a test log", "Main Function", null)
        assertTrue(result.contains("Main Function"))
        assertTrue(!result.contains("Checked:"))
    }

    @Test
    fun testDebugLiteWithEmptyMessage() {
        val result = debugLite(LogSeverity.LOG, "")
        assertTrue(result.contains(LogSeverity.LOG.toString()))
        assertTrue(result.contains("\n \n"))  // It should contain an empty line for the message
    }

    @Test
    fun testDebugLiteWithSpecialCharacters() {
        val result = debugLite(LogSeverity.LOG, "Message with newline\n and tab\t")
        assertTrue(result.contains("\\n"))
        assertTrue(result.contains("\\t"))
    }

    @Test
    fun testDebugLiteWithDifferentErrorTypes() {
        val errorTypes = LogSeverity.entries.toTypedArray()
        for (type in errorTypes) {
            val result = debugLite(type, "Testing various error types")
            assertTrue(result.contains(type.toString()))
        }
    }
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

