# Interview Solution

## Context

This solution was written during a coding interview.

## Problem Overview

The program calculates water consumption and billing for an apartment based on:

* Apartment type
* Water source ratios (Corporation vs Borewell)
* Additional guests

## Features

* Parses commands like:

  * ALLOT_WATER
  * ADD_GUESTS
  * BILL
* Computes total water consumption
* Applies slab-based pricing for tanker water

## Limitations

* Uses global variables
* No modular design
* Manual string-to-integer conversion
* Tight coupling between input parsing and business logic

## Purpose of this Folder

This serves as the baseline implementation before refactoring.
