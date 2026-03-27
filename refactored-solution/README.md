# Refactored Solution

## Overview

This is the improved version of the interview solution, refactored to follow clean code principles.

## Improvements Over Interview Version

* Separation of concerns:

  * Main → input handling
  * Handlers → command processing
  * Logic → business calculations
* Removed global state
* Improved readability and maintainability
* Modular design

## Design Approach

The system is structured into layers:

* Input Layer → Handles user commands
* Service Layer → Processes commands (Handlers)
* Logic Layer → Performs calculations