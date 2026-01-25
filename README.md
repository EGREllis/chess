Chess

To execute run:
docker compose up --build

in the root directory.

Current functionality:
Frontend can render a chess board with boardPieces.
Frontend loads the chess boardPieces from the backend.

Future functionality:
Frontend should encode moves and send them to the backend.
Backend should validate moves and return game state to the frontend.
One game should be playable in two browsers.

Stretch goal:
On mouse down, send event to backend, backend returns a list or valid positions for the piece,
frontend highlights these positions and only allows the piece to be dropped on them. 