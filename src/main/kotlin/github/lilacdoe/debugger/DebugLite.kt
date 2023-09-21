package github.lilacdoe.debugger

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

enum class LogSeverity {
    LOG, NOTE, WARN, ISSUE, ERROR, FATAL
}

private fun logDateTime(): String {
    val currentDateTime = LocalDateTime.now()
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

    val datestamp = currentDateTime.format(dateFormatter)
    val timestampWithMicrosec = currentDateTime.format(timeFormatter)

    return "$timestampWithMicrosec  |  $datestamp"
}

/**
 * Formats debug messages with timestamps, severity, and other optional context.
 *
 * @param errorSeverity The severity level. Keywords "LOG", "NOTE", "WARN", "ISSUE", "ERROR", or "FATAL" are recommended.
 * @param errorMsg The actual debug message describing the issue or log entry.
 * @param errorLocation (Optional) The caller where the issue occurred. Strongly recommended.
 * @param errorLogic (Optional) The condition or logic that triggered the debug message.
 * @return A formatted debug message.
 */
fun debugLite(
    errorSeverity: LogSeverity,
    errorMsg: String,
    errorLocation: String? = null,
    errorLogic: String? = null
): String {
    // Initialize outside methods
    val timestamp = logDateTime()
    // create local constants
    val headerStars = "*".repeat(60)
    val headerDashes = "-".repeat(60)

    // format header
    val debugHeader = buildString {
        appendLine(headerStars)
        appendLine("Error: $errorSeverity  |  $timestamp")
        // if errorLocation provided
        errorLocation?.let {
            appendLine("Location: $errorLocation")
        }
        appendLine(headerDashes)
    }

    // format body
    val debugBody = buildString {
        errorLogic?.let{
            // if errorLogic provided
            appendLine("Checked: $errorLogic")
        }
        appendLine("Log: $errorMsg")
        appendLine(headerStars)
    }

    return debugHeader + debugBody
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