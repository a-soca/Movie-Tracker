# Movie Tracker

| Index                                           |
|-------------------------------------------------|
| [Project Brief](#Project-Brief)                 |
| [Application Functions](#Application-Functions) |
| [Developer Tools](#Developer-Tools)             |
| [Further Development](#Further-Development)     |


## Project Brief
Don Robaldson is the CEO of MSR, a company that offers financial services to its
clients. Don is a very busy man, but in his spare time he very much enjoys
watching films and TV shows; there’s just one problem – Don can’t keep track of
which streaming services have which films/shows! So, he’s tasked the software
development team at MSR to develop a system to help him do just that.

## Application Functions
| Function       | Description                                                       |
| -------------- |-------------------------------------------------------------------|
| ServiceMenu    | Show All Available Services in the application repository         |
| MediaMenu      | Show All Available Streamable Media in the application repository |
| MyServices     | Show Services you have Tracked                                    |
| MyMedia        | Show Media you have Tracked                                       |
| ExclusiveTo    | Show Seasons Exclusive to a Service                               |
| TrackService   | Track a Streaming Service                                         |
| TrackMedia     | Track Media                                                       |
| AddRating      | Add a Rating to media you have tracked                            |
| UntrackService | Untrack a Streaming Service                                       |
| UntrackMedia   | Untrack Media                                                     |
| Exit           | Exit the application                                              |

## Developer Tools
- To add test streaming services, modify the `createStreamingServices()` method in the [MovieTrackerApp](src/main/java/org/msr/MovieTrackerApp.java) class
- To add test media, modify the `createMedia()` method in the [MovieTrackerApp](src/main/java/org/msr/MovieTrackerApp.java) class

## Further Development
- Allow users to create their own streaming services to add to the master repository
- Allow users to create their own streamable media to add to the master repository
- Add more media types