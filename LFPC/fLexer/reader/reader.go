package reader

import (
	"bufio"
	"compiler/lexer"
	"fmt"
	"go/token"
	"io"
)

func Start(in io.Reader, out io.Writer) {
	scanner := bufio.NewScanner(in)

	for {
		scanned := scanner.Scan()
		if !scanned {
			return
		}

		line := scanner.Text()
		lx := lexer.New(line)

		for tok := lx.NextToken(); tok.Type != token.MODA; tok = lx.NextToken() {
			fmt.Printf("%+v\n", tok)
		}
	}
}
