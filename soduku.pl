:- use_module(library(clpfd)).

% definir la forme de la grille sodoku: 9 listes, chaque liste contient
% 9 éléments
matrice9x9([
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_],
    [_,_,_,_,_,_,_,_,_]
]).

% La valeur d'un element de la grille doit etre comprise entre 1 et 9
element_entre_1_9(Element):- Element in 1..9.

% Les valeurs des elements d'une liste(ligne ou colonne) doivent etre comprises entre 1 et 9
elements_liste_entre_1_9(Liste):-maplist(element_entre_1_9(),Liste).

% Les valeurs des elements d'une grille doivent etre comprises entre 1 et 9
elements_Matrice_entre_1_9(Matrice):-maplist(elements_liste_entre_1_9(),Matrice).

% code provoque une attente illimitée: les elements d'une liste doivent
% avoir des valeurs differentes
%
% different_dans_liste([]).
% different_dans_liste([_,[]]).
% different_dans_liste([H|T]):-not(member(H,T)),different_dans_liste(T).

%les elements d'une liste doivent avoir des valeurs differentes
different_dans_liste(Liste):-all_distinct(Liste).

% les elements d'e chaque ligne de matrice doivent avoir des valeurs differentes
different_dans_lignes_matrice(Matrice):-maplist(different_dans_liste(),Matrice).

% inverser les ligne avec les colonnes, pour avoir une matrice composée
% de 9 listes, chaque liste represente les colonne de la grille (et non
% pas les ligne)
transpose_matrice([
	[X11,X12,X13,X14,X15,X16,X17,X18,X19],
	[X21,X22,X23,X24,X25,X26,X27,X28,X29],
	[X31,X32,X33,X34,X35,X36,X37,X38,X39],
	[X41,X42,X43,X44,X45,X46,X47,X48,X49],
	[X51,X52,X53,X54,X55,X56,X57,X58,X59],
	[X61,X62,X63,X64,X65,X66,X67,X68,X69],
	[X71,X72,X73,X74,X75,X76,X77,X78,X79],
	[X81,X82,X83,X84,X85,X86,X87,X88,X89],
	[X91,X92,X93,X94,X95,X96,X97,X98,X99]
],[
	[X11,X21,X31,X41,X51,X61,X71,X81,X91],
	[X12,X22,X32,X42,X52,X62,X72,X82,X92],
	[X13,X23,X33,X43,X53,X63,X73,X83,X93],
	[X14,X24,X34,X44,X54,X64,X74,X84,X94],
	[X15,X25,X35,X45,X55,X65,X75,X85,X95],
	[X16,X26,X36,X46,X56,X66,X76,X86,X96],
	[X17,X27,X37,X47,X57,X67,X77,X87,X97],
	[X18,X28,X38,X48,X58,X68,X78,X88,X98],
	[X19,X29,X39,X49,X59,X69,X79,X89,X99]
]).

% construire 3 sous matrices 3x3 avec 3 listes (lignes) et tester si les
% valeurs des elements de cette sous matrice sont differentes
different_dans_blocs3x3([],[],[]).
different_dans_blocs3x3([E1,E2,E3|Reste_liste_1],
                        [E4,E5,E6|Reste_liste_2],
                        [E7,E8,E9|Reste_liste_3]):-
   % different_dans_liste([E1,E2,E3,E4,E5,E6,E7,E8,E9]),
    all_distinct([E1,E2,E3,E4,E5,E6,E7,E8,E9]),
    different_dans_blocs3x3(Reste_liste_1,Reste_liste_2,Reste_liste_3).



sodoku(Matrice,Solution):-
    %fixer la forme de la matrice
    matrice9x9(Matrice),

    %fixer le domaine des valeurs des elements de la matrice (de 1 a 9)
   % elements_Matrice_entre_1_9(Matrice),
    append(Matrice,Aux), Aux ins 1..9,

    %contrainte de difference entre les valeurs des elements des lignes de la matrice
   % different_dans_lignes_matrice(Matrice),
    maplist(all_distinct, Matrice),

    %transposé de la matrice (les listes contient les elements des colonnes)
    transpose_matrice(Matrice, Transpose),

    %contrainte de difference entre les valeurs des elements des colonnes de la matrice
   % different_dans_lignes_matrice(Transpose),
    maplist(all_distinct, Transpose),

    %contrainte de la forme de la matrice (9 listes)
    Matrice= [L1,L2,L3,L4,L5,L6,L7,L8,L9],

    %les valeurs des elements de chaque sous matrice doivent etre differents.
    % les 3 premiers listes forme 3 sous matrice 3x3,
    different_dans_blocs3x3(L1,L2,L3),
    % la 4,5,6 eme listes forme 3 sous matrice 3x3,
    different_dans_blocs3x3(L4,L5,L6),
    % la 7,8,9 eme emes listes forme 3 sous matrice 3x3,
    different_dans_blocs3x3(L7,L8,L9),
    append(Matrice,[],Solution).


test(R):-
    sodoku([
[5,4,_,_,2,_,8,_,6],
[_,1,9,_,_,7,_,_,3],
[_,_,_,3,_,_,2,1,_],
[9,_,_,4,_,5,_,2,_],
[_,_,1,_,_,_,6,_,4],
[6,_,4,_,3,2,_,8,_],
[_,6,_,_,_,_,1,9,_],
[4,_,2,_,_,9,_,_,5],
[_,9,_,_,7,_,4,_,2]],R).


test2(R):-sodoku([[_,_,_,_,_,_,_,1,_],
[_,_,_,_,_,2,_,_,3],
[_,_,_,4,_,_,_,_,_],
[_,_,_,_,_,_,5,_,_],
[4,_,1,6,_,_,_,_,_],
[_,_,7,1,_,_,_,_,_],
[_,5,_,_,_,_,2,_,_],
[_,_,_,_,8,_,_,4,_],
[_,3,_,9,1,_,_,_,_]],R).

test3(R):-sodoku([
[3,_,_,_,_,_,_,_,5],
[9,_,4,8,6,_,_,_,_],
[_,_,_,_,_,_,4,8,_],
[_,_,_,1,_,_,_,3,6],
[_,_,8,_,_,_,_,_,4],
[_,_,_,_,_,_,1,7,_],
[4,_,_,_,9,_,5,_,3],
[_,6,_,_,7,_,_,_,8],
[_,_,9,_,_,3,_,_,_]],R).