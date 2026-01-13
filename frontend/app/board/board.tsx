import React from 'react';
import {useState} from 'react';

function convertPieceToSvg(piece) {
    const x = piece.x;
    const y = piece.y;
    const colour = piece.colour;
    const type = piece.type;

    const tx = x * 50;
    const ty = y * 50;
    const translateCode="translate("+tx+","+ty+")";
    const fill = colour === "black" ? "#000000" : "#ffffff";
    const stroke = colour === "black" ? "#ffffff" : "#000000";

    const stylePawn = {
        opacity: 1,
        fill: fill,
        "fill-opacity": 1,
        "fill-rule": "nonzero",
        stroke: stroke,
        "stroke-width": 1.5,
        "stroke-linecap": "round",
        "stroke-linejoin": "miter",
        "stroke-miterlimit": 4,
        "stroke-dasharray": "none",
        "stroke-opacity":1
    };

    const styleRook = {
        opacity: 1,
        fill: fill,
        "fill-opacity": 1,
        "fill-rule": "evenodd",
        stroke: stroke,
        "stroke-width": 1.5,
        "stroke-linecap": "round",
        "stroke-linejoin": "round",
        "stroke-miterlimit": 4,
        "stroke-dasharray": "none",
        "stroke-opacity": 1
    };
    const styleRookLineCap = {
        "stroke-linecap": "butt"
    };
    const styleRookLineCapJoin = {
        "stroke-linecap": "butt",
        "stroke-linejoin": "miter"
    };
    const styleRookNoFill = {
        "fill": "none",
         "stroke": stroke,
         "stroke-width": 1,
         "stroke-linejoin": "miter"
    };

    const styleKnight = {
        opacity: 1,
        fill: "none",
        "fill-opacity": 1,
        "fill-rule": "evenodd",
         "stroke": stroke,
         "stroke-width": 1.5,
         "stroke-linecap": "round",
         "stroke-linejoin": "round",
         "stroke-miterlimit": 4,
         "stroke-dasharray": "none",
         "stroke-opacity":1
    };
    const styleKnightBase = {
        fill: fill,
        stroke: stroke
    };
    const styleKnightAccent = {
        fill: stroke,
        stroke: stroke
    };
    const styleKnightAccentNoStroke = {
        fill: stroke,
        stroke: "none"
    };

    const styleBishop = {
        opacity: 1,
        fill: "none",
        "fill-rule": "evenodd",
        "fill-opacity": 1,
        stroke: stroke,
        "stroke-width": 1.5,
        "stroke-linecap": "round",
        "stroke-linejoin": "round",
        "stroke-miterlimit": 4,
        "stroke-dasharray": "none",
        "stroke-opacity": 1
    };
    const styleBishopMain = {
        fill: fill,
        stroke: stroke,
        "stroke-linecap": "butt"
    };
    const styleBishopAlt = {
        fill: "none",
        stroke: stroke,
        "stroke-linejoin": "miter"
    };

    const styleQueen = {
        opacity: 1,
        fill: fill,
        "fill-opacity": 1,
        "fill-rule": "evenodd",
        stroke: stroke,
        "stroke-width": 1.5,
        "stroke-linecap": "round",
        "stroke-linejoin": "round",
        "stroke-miterlimit": 4,
        "stroke-dasharray": "none",
        "stroke-opacity": 1
    };
    const styleQueenOrb = {
        fill: fill,
        stroke: "none"
    };
    const styleQueenNoFill = {
        fill: "none",
        stroke: stroke
    };
    const styleQueenLineCapOnly = {
        "stroke-linecap": "butt"
    };
    const styleQueenLineCapAndStroke = {
        "stroke-linecap": "butt",
        stroke: fill
    };
    const styleQueenLineCapStrokeNoFill = {
        fill: "none",
        stroke: fill,
        "stroke-linecap": "butt"
    };

    const styleKing = {
        fill: "none",
        "fill-opacity": 1,
        "fill-rule": "evenodd",
        "stroke": fill,
        "stroke-width": 1.5,
        "stroke-linecap": "round",
        "stroke-linejoin": "round",
        "stroke-miterlimit": 4,
        "stroke-dasharray": "none",
        "stroke-opacity": 1
    };
    const styleKingNoFill = {
        fill: "none",
        stroke: stroke
    };
    const styleKingNoStroke = {
        fill: fill,
        stroke: fill
    };
    const styleKingNoFillLineJoin = {
        fill: "none",
        stroke: fill,
        "stroke-linejoin": "miter"
    };
    const styleKingLineCap = {
        fill: fill,
        "fill-opacity": 1,
        "stroke-linecap": "butt",
        "stroke-linejoin": "miter"
    }
    const styleKingNoFillLineJoinAlt = {
        fill: "none",
        stroke: fill,
        "stroke-linejoin": "miter"
    };

    switch (type) {
        case "pawn":
            return <g transform={translateCode}>
                                          <path
                                          d="M 22,9 C 19.79,9 18,10.79 18,13 C 18,13.89 18.29,14.71 18.78,15.38 C 16.83,16.5 15.5,18.59 15.5,21 C 15.5,23.03 16.44,24.84 17.91,26.03 C 14.91,27.09 10.5,31.58 10.5,39.5 L 33.5,39.5 C 33.5,31.58 29.09,27.09 26.09,26.03 C 27.56,24.84 28.5,23.03 28.5,21 C 28.5,18.59 27.17,16.5 25.22,15.38 C 25.71,14.71 26,13.89 26,13 C 26,10.79 24.21,9 22,9 z "
                                          style={stylePawn} />
                   </g>;
        case "rook":
            return <g transform={translateCode}>
                        <g style={styleRook}>
                                <path
                                d="M 9,39 L 36,39 L 36,36 L 9,36 L 9,39 z "
                                style={styleRookLineCap} />
                                <path
                                d="M 12.5,32 L 14,29.5 L 31,29.5 L 32.5,32 L 12.5,32 z "
                                style={styleRookLineCap} />
                                <path
                                d="M 12,36 L 12,32 L 33,32 L 33,36 L 12,36 z "
                                style={styleRookLineCap} />
                                <path
                                d="M 14,29.5 L 14,16.5 L 31,16.5 L 31,29.5 L 14,29.5 z "
                                style={styleRookLineCapJoin} />
                                <path
                                d="M 14,16.5 L 11,14 L 34,14 L 31,16.5 L 14,16.5 z "
                                style={styleRookLineCap} />
                                <path
                                d="M 11,14 L 11,9 L 15,9 L 15,11 L 20,11 L 20,9 L 25,9 L 25,11 L 30,11 L 30,9 L 34,9 L 34,14 L 11,14 z "
                                style={styleRookLineCap} />
                                <path
                                d="M 12,35.5 L 33,35.5 L 33,35.5"
                                style={styleRookNoFill} />
                                <path
                                d="M 13,31.5 L 32,31.5"
                                style={styleRookNoFill} />
                                <path
                                d="M 14,29.5 L 31,29.5"
                                style={styleRookNoFill} />
                                <path
                                d="M 14,16.5 L 31,16.5"
                                style={styleRookNoFill} />
                                <path
                                d="M 11,14 L 34,14"
                                style={styleRookNoFill} />
                        </g>
            </g>;
        case "knight":
            return <g transform={translateCode}>
                <g style={styleKnight}>
                        <path
                           d="M 22,10 C 32.5,11 38.5,18 38,39 L 15,39 C 15,30 25,32.5 23,18"
                           style={styleKnightBase} />
                        <path
                           d="M 24,18 C 24.38,20.91 18.45,25.37 16,27 C 13,29 13.18,31.34 11,31 C 9.958,30.06 12.41,27.96 11,28 C 10,28 11.19,29.23 10,30 C 9,30 5.997,31 6,26 C 6,24 12,14 12,14 C 12,14 13.89,12.1 14,10.5 C 13.27,9.506 13.5,8.5 13.5,7.5 C 14.5,6.5 16.5,10 16.5,10 L 18.5,10 C 18.5,10 19.28,8.008 21,7 C 22,7 22,10 22,10"
                           style={styleKnightBase} />
                        <path
                           d="M 9.5 25.5 A 0.5 0.5 0 1 1 8.5,25.5 A 0.5 0.5 0 1 1 9.5 25.5 z"
                           style={styleKnightAccent} />
                        <path
                           d="M 15 15.5 A 0.5 1.5 0 1 1  14,15.5 A 0.5 1.5 0 1 1  15 15.5 z"
                           transform="matrix(0.866,0.5,-0.5,0.866,9.693,-5.173)"
                           style={styleKnightAccent} />
                        <path
                           d="M 24.55,10.4 L 24.1,11.85 L 24.6,12 C 27.75,13 30.25,14.49 32.5,18.75 C 34.75,23.01 35.75,29.06 35.25,39 L 35.2,39.5 L 37.45,39.5 L 37.5,39 C 38,28.94 36.62,22.15 34.25,17.66 C 31.88,13.17 28.46,11.02 25.06,10.5 L 24.55,10.4 z "
                           style={styleKnightAccentNoStroke} />
                    </g>
            </g>;
        case "bishop":
            return <g transform={translateCode}>
                <g style={styleBishop}>
                        <g style={styleBishopMain}>
                            <path
                                d="M 9,36 C 12.39,35.03 19.11,36.43 22.5,34 C 25.89,36.43 32.61,35.03 36,36 C 36,36 37.65,36.54 39,38 C 38.32,38.97 37.35,38.99 36,38.5 C 32.61,37.53 25.89,38.96 22.5,37.5 C 19.11,38.96 12.39,37.53 9,38.5 C 7.646,38.99 6.677,38.97 6,38 C 7.354,36.06 9,36 9,36 z" />
                            <path
                                d="M 15,32 C 17.5,34.5 27.5,34.5 30,32 C 30.5,30.5 30,30 30,30 C 30,27.5 27.5,26 27.5,26 C 33,24.5 33.5,14.5 22.5,10.5 C 11.5,14.5 12,24.5 17.5,26 C 17.5,26 15,27.5 15,30 C 15,30 14.5,30.5 15,32 z" />
                            <path
                                d="M 25 8 A 2.5 2.5 0 1 1  20,8 A 2.5 2.5 0 1 1  25 8 z" />
                        </g>
                        <path
                           d="M 17.5,26 L 27.5,26 M 15,30 L 30,30 M 22.5,15.5 L 22.5,20.5 M 20,18 L 25,18"
                           style={styleBishopAlt} />
                    </g>
            </g>;
        case "queen":
            return <g transform={translateCode}>
                <g style={styleQueen}>
                        <g style={styleQueenOrb}>
                            <circle cx="6"    cy="12" r="2.75" />
                            <circle cx="14"   cy="9"  r="2.75" />
                            <circle cx="22.5" cy="8"  r="2.75" />
                            <circle cx="31"   cy="9"  r="2.75" />
                            <circle cx="39"   cy="12" r="2.75" />
                        </g>
                        <path
                        d="M 9,26 C 17.5,24.5 30,24.5 36,26 L 38.5,13.5 L 31,25 L 30.7,10.9 L 25.5,24.5 L 22.5,10 L 19.5,24.5 L 14.3,10.9 L 14,25 L 6.5,13.5 L 9,26 z"
                        style={styleQueenLineCapAndStroke} />
                        <path
                        d="M 9,26 C 9,28 10.5,28 11.5,30 C 12.5,31.5 12.5,31 12,33.5 C 10.5,34.5 10.5,36 10.5,36 C 9,37.5 11,38.5 11,38.5 C 17.5,39.5 27.5,39.5 34,38.5 C 34,38.5 35.5,37.5 34,36 C 34,36 34.5,34.5 33,33.5 C 32.5,31 32.5,31.5 33.5,30 C 34.5,28 36,28 36,26 C 27.5,24.5 17.5,24.5 9,26 z"
                        style={styleQueenLineCapOnly} />
                        <path
                        d="M 11,38.5 A 35,35 1 0 0 34,38.5"
                        style={styleQueenLineCapStrokeNoFill} />
                        <path
                        d="M 11,29 A 35,35 1 0 1 34,29"
                        style={styleQueenNoFill} />
                        <path
                        d="M 12.5,31.5 L 32.5,31.5"
                        style={styleQueenNoFill} />
                        <path
                        d="M 11.5,34.5 A 35,35 1 0 0 33.5,34.5"
                        style={styleQueenNoFill} />
                        <path
                        d="M 10.5,37.5 A 35,35 1 0 0 34.5,37.5"
                        style={styleQueenNoFill} />
                    </g>
            </g>;
        case "king":
            return <g transform={translateCode}>
                <g style={styleKing}>
                        <path
                            d="M 22.5,11.63 L 22.5,6"
                            style={styleKingNoFillLineJoin} />
                        <path
                            d="M 22.5,25 C 22.5,25 27,17.5 25.5,14.5 C 25.5,14.5 24.5,12 22.5,12 C 20.5,12 19.5,14.5 19.5,14.5 C 18,17.5 22.5,25 22.5,25"
                            style={styleKingLineCap} />
                        <path
                           d="M 11.5,37 C 17,40.5 27,40.5 32.5,37 L 32.5,30 C 32.5,30 41.5,25.5 38.5,19.5 C 34.5,13 25,16 22.5,23.5 L 22.5,27 L 22.5,23.5 C 19,16 9.5,13 6.5,19.5 C 3.5,25.5 11.5,29.5 11.5,29.5 L 11.5,37 z "
                           style={styleKingNoStroke} />
                        <path
                           d="M 20,8 L 25,8"
                           style={styleKingNoFillLineJoinAlt} />
                        <path
                           d="M 32,29.5 C 32,29.5 40.5,25.5 38.03,19.85 C 34.15,14 25,18 22.5,24.5 L 22.51,26.6 L 22.5,24.5 C 20,18 9.906,14 6.997,19.85 C 4.5,25.5 11.85,28.85 11.85,28.85"
                           style={styleKingNoFill} />
                        <path
                           d="M 11.5,30 C 17,27 27,27 32.5,30 M 11.5,33.5 C 17,30.5 27,30.5 32.5,33.5 M 11.5,37 C 17,34 27,34 32.5,37"
                           style={styleKingNoFill} />
                    </g>
            </g>;
        default:
            return <g></g>;
    }
}

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

    const [currentPieces, setCurrentPieces] = useState({
        turn:"white",
        pieces:[{x:0,   y:0,    colour:"black", type:"rook"},
                {x:1,   y:0,    colour:"black", type:"knight"},
                {x:2,   y:0,    colour:"black", type:"bishop"},
                {x:3,   y:0,    colour:"black", type:"king"},
                {x:4,   y:0,    colour:"black", type:"queen"},
                {x:5,   y:0,    colour:"black", type:"bishop"},
                {x:6,   y:0,    colour:"black", type:"knight"},
                {x:7,   y:0,    colour:"black", type:"rook"},
                {x:0,   y:1,    colour:"black", type:"pawn"},
                {x:1,   y:1,    colour:"black", type:"pawn"},
                {x:2,   y:1,    colour:"black", type:"pawn"},
                {x:3,   y:1,    colour:"black", type:"pawn"},
                {x:4,   y:1,    colour:"black", type:"pawn"},
                {x:5,   y:1,    colour:"black", type:"pawn"},
                {x:6,   y:1,    colour:"black", type:"pawn"},
                {x:7,   y:1,    colour:"black", type:"pawn"},
                {x:0,   y:6,    colour:"white", type:"pawn"},
                {x:1,   y:6,    colour:"white", type:"pawn"},
                {x:2,   y:6,    colour:"white", type:"pawn"},
                {x:3,   y:6,    colour:"white", type:"pawn"},
                {x:4,   y:6,    colour:"white", type:"pawn"},
                {x:5,   y:6,    colour:"white", type:"pawn"},
                {x:6,   y:6,    colour:"white", type:"pawn"},
                {x:7,   y:6,    colour:"white", type:"pawn"},
                {x:0,   y:7,    colour:"white", type:"rook"},
                {x:1,   y:7,    colour:"white", type:"knight"},
                {x:2,   y:7,    colour:"white", type:"bishop"},
                {x:3,   y:7,    colour:"white", type:"king"},
                {x:4,   y:7,    colour:"white", type:"queen"},
                {x:5,   y:7,    colour:"white", type:"bishop"},
                {x:6,   y:7,    colour:"white", type:"knight"},
                {x:7,   y:7,    colour:"white", type:"rook"},
                // More to follow but really ought to be provided by the server
                ]
        });

    const piecesSvgJsx = currentPieces.pieces.map( (piece) =>
        convertPieceToSvg(piece)
    );

    const pieces = React.createElement('g',{},piecesSvgJsx);

    return (<svg
        xmlns="http://www.w3.org/2000/svg"
        width="640"
        height="640"
        viewBox="0 0 400 400">
                <rect x="0" y="0" height="400" width="400" fill="darkblue"/>

                {squares}
                {pieces}
            </svg>);
}

export default Board;