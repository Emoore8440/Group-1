Student Support Hub (Java Console Application)
Overview

Student Support Hub is a Java-based console application designed to help students access support resources, manage profiles, communicate with campus organizations, and discover student groups.

The program acts as a centralized hub where users can create profiles, send messages to support organizations, browse student groups, and determine eligibility for financial aid resources through an intake quiz.

This project was developed as a collaborative group project demonstrating core Java programming concepts including object-oriented design, collections, exception handling, recursion, and modular class structure.

Features

1. Profile Management

Users can create and manage student profiles.

Capabilities:

-Create new student profiles

-Edit existing profiles

-Delete profiles

-Select an active profile

-View currently selected profile

Profiles store:

-Name

-Age

-Email

Profiles are stored in an ArrayList and accessed through a console menu system.


2. Student Mail System

The mail system allows users to send messages to predefined campus support organizations.

Capabilities:

-Send messages to support groups

-View previously sent messages

-Messages stored separately per profile

Messages are stored using a HashMap, ensuring each profile only sees its own sent messages.


3. Student Library / Resources

The library system acts as a support resource hub.

Capabilities:

-Access informational resources

-Complete an intake eligibility quiz

The intake quiz evaluates a student's situation to help determine potential eligibility for financial aid or support programs.


4. Financial Aid Intake Quiz

A console-based questionnaire that evaluates potential financial aid eligibility.

Questions Include:

-Annual income

-Number of dependents

-Disability or health considerations

Eligibility recommendation based on responses

Possible results include:

-Eligible for financial aid

-Possibly eligible for scholarships

-Not likely eligible



5. Student Group System

Allows users to browse and join student support groups.

Capabilities:

-View available groups

-Display detailed group information

-Join groups

-View contact information for group managers

Preloaded Groups:

-STEM Mentorship Club

-Women in Tech

-LGBTQ+ Support


Program Architecture

The project is organized using a modular class structure.

Core Classes
Class	       Purpose
StudHub	     Main program entry point and central menu system
StudProfile	 Manages student profiles and profile operations
StudMail	   Handles messaging between profiles and support groups
StudLib	     Manages the resource library and intake quiz access
StudReqs	   Implements the financial aid eligibility quiz
GroupSystem	 Manages student group browsing and joining
