package lexer

import "Lexer/tokens"


type Lexer struct {
	input        string
	position     int
	nextPosition int
	ch           byte
}

//New function
func New(input string) *Lexer {
	lx := &Lexer{input: input}
	lx.readChar()
	return lx
}

//NextToken fun
func (lx *Lexer) NextToken() token.Token {
	var tok token.Token

	lx.skipWhitespace()

	switch lx.ch {

	case '=':
		tok = newToken(token.EQUAL, lx.ch)
  case '*':
		tok = newToken(token.MULT, lx.ch)
  case '/':
		tok = newToken(token.DIVIDE, lx.ch)
  case '+':
		tok = newToken(token.PLUS, lx.ch)
	case '-':
		tok = newToken(token.MINUS, lx.ch)
	case '>':
		tok = newToken(token.MORE, lx.ch)
	case '<':
		tok = newToken(token.LESS, lx.ch)

	case ';':
		tok = newToken(token.SEMICOLON, lx.ch)
	case ',':
		tok = newToken(token.COMMA, lx.ch)
		
	case '(':
		tok = newToken(token.LP, lx.ch)
	case ')':
		tok = newToken(token.RP, lx.ch)
	case '{':
		tok = newToken(token.LBR, lx.ch)
	case '}':
		tok = newToken(token.RBR, lx.ch)

	case 0:
		tok.Input = ""
		tok.Type = token.MODA
	default:
		if isLetter(lx.ch) {
			tok.Input = lx.readIdentifier()
			tok.Type = token.LookupIdent(tok.Input)
			return tok
		} else if isDigit(lx.ch) {
			tok.Type = token.INT
			tok.Input = lx.readNumber()
			return tok
		} else {
			tok = newToken(token.ORA, lx.ch)
		}
	}
	lx.readChar()
	return tok
}

func (lx *Lexer) skipWhitespace() {
	for lx.ch == ' ' || lx.ch == '\t' || lx.ch == '\n' || lx.ch == '\r' {
		lx.readChar()
	}
}

func (lx *Lexer) readChar() {
	if lx.nextPosition >= len(lx.input) {
		lx.ch = 0
	} else {
		lx.ch = lx.input[lx.nextPosition]
	}
	lx.position = lx.nextPosition
	lx.nextPosition++
}

func (lx *Lexer) readIdentifier() string {
	position := lx.position
	for isLetter(lx.ch) {
		lx.readChar()
	}
	return lx.input[position:lx.position]
}

func isLetter(ch byte) bool {
	return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '_'
}

func (lx *Lexer) readNumber() string {
	position := lx.position
	for isDigit(lx.ch) {
		lx.readChar()
	}
	return lx.input[position:lx.position]
}

func isDigit(ch byte) bool {
	return '0' <= ch && ch <= '9'
}

func newToken(tokenType token.TokenType, ch byte) token.Token {
	return token.Token{Type: tokenType, Input: string(ch)}
}
