import React from 'react';

export function Board() {
    const lightSquares = [  {x:0,y:0},  {x:2,y:0},  {x:4,y:0},  {x:6,y:0},
                            {x:1,y:1},  {x:3,y:1},  {x:5,y:1},  {x:7,y:1},
                            {x:0,y:2},  {x:2,y:2},  {x:4,y:2},  {x:6,y:2},
                            {x:1,y:3},  {x:3,y:3},  {x:5,y:3},  {x:7,y:3},
                            {x:0,y:4},  {x:2,y:4},  {x:4,y:4},  {x:6,y:4},
                            {x:1,y:5},  {x:3,y:5},  {x:5,y:5},  {x:7,y:5},
                            {x:0,y:6},  {x:2,y:6},  {x:4,y:6},  {x:6,y:6},
                            {x:1,y:7},  {x:3,y:7},  {x:5,y:7},  {x:7,y:7}
                         ];
    const lightSquaresSvgJsx = lightSquares.map( (point) => (
        React.createElement('rect', {x: (point.x * 50), y: (point.y * 50), height: 50, width: 50, fill: "lightgreen"},)
        ));

    const squares = React.createElement('g',{},lightSquaresSvgJsx);
    console.log(squares);
    return (<svg
        xmlns="http://www.w3.org/2000/svg"
        width="640"
        height="640"
        viewBox="0 0 400 400">
                <rect x="0" y="0" height="400" width="400" fill="darkblue"/>

                {squares}
            </svg>);
}

export default Board;