# Recipe-App

A Java-based web application to manage, browse, and plan meals using recipes.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Setup & Running](#setup--running)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- User authentication / login  
- Add / edit / delete recipes  
- Recipe categories (e.g. appetizers, mains, desserts)  
- Search recipes by name / ingredient  
- Meal planning (compose a set of recipes for a day/period)  
- Display recipe details (ingredients, instructions, etc.)

---

## Tech Stack

- **Java** (servlets / backend logic)  
- **JSP / Java Forms** (frontend templates)  
- **MySQL**

---

## Project Structure
/
├── HomePage.form
├── HomePage.java
├── LoginPage.form
├── LoginPage.java
├── addRecipe.form
├── addRecipe.java
├── recipeCategory.form
├── recipeCategory.java
├── recipeDisplay.form
├── recipeDisplay.java
├── saveRecipe.form
├── saveRecipe.java
├── searchResult.form
├── searchResult.java
├── mealPlans.java
└── ComputerScienceIA.java

- `.form` → frontend pages  
- `.java` → backend controllers / logic  
- `mealPlans.java` → meal planning handler  
- `ComputerScienceIA.java` → Project entry point

---

## Setup & Running

```bash
git clone https://github.com/yvonnelxxxx/Recipe-App.git
cd Recipe-App
Install Java (JDK version X.X).

Import into an IDE or compile manually.

Deploy to a servlet container (e.g. Apache Tomcat)

Open in browser (example):

http://localhost:8080/Recipe-App/

---

## Usage

Log in or register

Add new recipes

Browse by category or search

View ingredients and steps

Use meal plan feature to assemble meals

---

## Contributing

Fork the repo

Create a feature branch

Commit & push changes

Open a pull request

---

## License

Licensed under the MIT License. See LICENSE for details.


---