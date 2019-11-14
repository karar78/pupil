
# A Restful application for registering users

# Docker Related
1- Skip step 2 and step 3 if Docker is already installed on your local machine
2- Download Docker from https://www.docker.com/products/docker-desktop
3- Install the downloaded application on your local machine and start runnng it
4- Open command shell and type below command (it may take few minutes to download all libraries)
	docker pull khsbangash/docker-pupil

5- Once download finishes, make sure that the docker image has been downloaded successfully by below command:
	docker images

6- Run command to run the docker image
	docker run -p 9876:8080 khsbangash/docker-pupil:latest
	(Note: You may use any port instead of 9876)


# Using Application - How to access endpoints of the application
1- Download and install postman 

2- Use Post method to register a new user:
	URL: http://localhost:9876/users
	JSON data format: {"firstName": "Karar", "lastName": "Haider"}
Upon successful registration of the user, you will see status code 200 and ID of the user will be shown.

3- Use Get method to view information related to a user, using his ID number:
	URL: http://localhost:9876/users/{id}
	where {id} is the ID number of the user
	e.g: for ID number 1, the URL is shown below:
	http://localhost:9876/users/1

# Source Code
1- The source code could be downloaded from Github at below URL:
	https://github.com/karar78/pupil.git
2- Once downloaded, the files are ready to be imported in to your favorite IDE.

Thank you.

