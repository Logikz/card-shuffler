# card-shuffler
Web service to shuffle cards

# Build with Maven
mvn clean install

# Running
cd target

java -jar card-shuffler-1.0-SNAPSHOT.jar [basic | human]

Runs a webservice listening on port 8080

# Arguments
## basic
Simulates an in-order shuffling algorithm with 1000 swaps
## human
Simulates a human style shuffling algorithm where the deck is split in half and attempted to be interleaved back to a single deck

# REST Api
All REST endpoints return JSON

## GET /api/deck/{name}
Gets a deck by specified name
## PUT /api/deck/{name}
Creates a new deck with the given name
## POST /api/deck/{name}
Shuffles a deck with a given name
## DELETE /api/deck/{name}
Deletes a deck with a given name
## GET /api/deck
Gets all decks created in the system

# Tests
mvn test