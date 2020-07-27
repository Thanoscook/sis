# SIS JAVA TECHNICAL TEST

1) For the task Spring boot was used as it is mentioned in the job description that is used by SIS

2) I have included the target foldler in the comit so you can run the app using < java -jar target/demo-0.0.1-SNAPSHOT.jar > command

3) endpoinds: hostname:8080/all-teams Returns a list all teams available 
              hostname:8080/by-stadium-capacity Returns a list of alll teams sorted by stadium capacity
              hostname:8080/team-details Requires parameter name and returns details of the team with that name
              hostname:8080/add-team A post request here will add a new team given the following parameters:     
                   String name
                   String city
                   String owner
                   int stadiumCapacity
                   String competition
                   int numberOfPlayers
                   Date founded

