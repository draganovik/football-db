
# Football Information Service

Razvoj višeslojnih aplikacija 2021 / 2022 [6. semestar]

![soccer_ball2](https://user-images.githubusercontent.com/15861333/174421336-09f8ffef-21bf-4cf7-aab5-99480c2db1cd.svg)

## Badges

[![Netlify Status](https://api.netlify.com/api/v1/badges/cef86994-4fce-4da2-8713-f9f727311f0e/deploy-status)](https://app.netlify.com/sites/rva-it68g2019/deploys) ![Heroku](https://pyheroku-badge.herokuapp.com/?app=rva-it68g2019&style=flat) [![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
  
## Demo

Angular Web Client: [https://rva-it68g2019.netlify.app](https://rva-it68g2019.netlify.app)

Spring Boot Server: [https://rva-it68g2019.herokuapp.com](https://rva-it68g2019.herokuapp.com)

## Tech Stack

- Database
    - PostgreSQL
- Backend
    - Java Spring Boot
    - Java Persistence API (JPA)
    - Hibernate ORM
- Frontend
    - Angular
    - Angular Material
  
## Environment Variables

To run this project, you will need to add the following environment variables to your enviroment

### Spring Boot server

- `spring.datasource.url` - Database URI
- `spring.datasource.username` - Database user
- `spring.datasource.password` - Database user password
- `server.port` - Server port

### Angular web client

- `NATIONALITIES_URI` - Nationalities API endpoint
- `LEAGUES_URI` - Leagues API endpoint
- `TEAMS_URI` - Football teams API endpoint
- `PLAYERS_URI` - Players API endpoint
- `PLAYER_TEAM_URI` - Get player by team ID API endpoint

## Screenshots

| Dashboard |  Football Teams | Players Table |
:-------------------------:|:-------------------------:|:-------------------------:
![Web capture_18-6-2022_53212_rva-it68g2019 netlify app](https://user-images.githubusercontent.com/15861333/174421390-ba8a4bcd-a1ef-41e4-9f1d-ec2ad673db06.jpeg) | ![Web capture_18-6-2022_53230_rva-it68g2019 netlify app](https://user-images.githubusercontent.com/15861333/174421398-6a40f791-e69d-4701-b2c8-f658b9205a19.jpeg) | ![Web capture_18-6-2022_53256_rva-it68g2019 netlify app](https://user-images.githubusercontent.com/15861333/174421404-7b2c92d2-a674-4303-80ca-2ebc34465968.jpeg)

## Author

- Name: **Mladen Draganović**
- Index: **IT68/2019**
- GitHub: [@draganovik](https://github.com/draganovik)
- Website: [draganovik.com](https://draganovik.com)
- Contact: [draganovik.com/contact](https://draganovik.com/contact)

## Acknowledgements

 - [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
 - [Awesome README](https://github.com/matiassingers/awesome-readme)
 - [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)
