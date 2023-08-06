grammar PropertyFile;

@members {
    public void startFile(){ }
    public void finishFile(){ }
    public void defineProperty(Token name,Token value){ }
}
file : {startFile();} prop+ {finishFile();};
prop : ID '=' STRING '\n' {defineProperty($ID, $STRING);};
ID : [a-z]+;
STRING : '"' .*? '"';