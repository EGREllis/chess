import React from 'react';
import { useState } from 'react';

function Lobby() {
  const [games, setGames] = useState([
    {host: "James", hostColour: "Black", isBlackAvailable: false, isWhiteAvailable: true, isWatchable: false}
  ]);

  const headers = (
    <thead>
        <tr><th>Black</th><th>White</th><th>Watch</th></tr>
    </thead>
  )

  const rows = [];
  for (var i = 0; i < games.length; i++) {
    var game = games[i];
    var row = (
        <tr>
            <td>{game.isBlackAvailable ? (<button>Play</button>) : (<p>{game.host}</p>) }</td>
            <td>{game.isWhiteAvailable ? (<button>Play</button>) : (<p>{game.host}</p>) }</td>
            <td>{game.isWatchable ? (<button>Watch</button>) : (<div></div>)}</td>
        </tr>
    )
    rows.push(row);
  }
  const footer = (
    <tr>
        <td><button>New game as Black</button></td>
        <td><button>New game as White</button></td>
        <td></td>
    </tr>
  )
  rows.push(footer);

  return (
    <div className="Lobby">
      <form>
        <table className="center">
          {headers}
          {React.createElement("tbody", {}, rows)}
        </table>
      </form>
    </div>
  );
};

export default Lobby;