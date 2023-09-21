# DebugLite: Simple Debug Message Formatter

DebugLite is a lightweight library designed to format your debug messages. It enhances the readability of your debug logs and provides essential information to diagnose issues. Note that all parameters must be manually assigned.

## Using `debugLite()`

- **`errorType` (Required)**: Specify the severity level using one of the following keywords:
  - `LOG` = success - routine events, usually suppressed
  - `NOTE` = success - noteworthy events, often reported
  - `WARN` = resolved - minor errors, program likely to work as intended
  - `ISSUE` = resolved - major errors, program not likely to work as intended
  - `ERROR` = unresolved - critical error, program stability may be affected
  - `FATAL` = unresolved - fatal error, program forced to terminate/enter fail state

    Note: Keyword functionality is available only in the full debugger.

- **`errorMsg` (Required)**: The message you want to display to explain the issue or log entry.

- **`errorLocation` (Optional)**: Name of the method or function where the log or error occurred. It's strongly recommended.

- **`errorLogic` (Optional)**: Condition or logic that triggered the debug message (e.g., `if x > y`).

## Example Usage

```kotlin
debugLite(
    errorType = "ERROR",
    errorMsg = "Array out of bounds",
    errorLocation = "calculateSum",
    errorLogic = "if index > array.length"
)
