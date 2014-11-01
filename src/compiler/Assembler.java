package compiler;

/**
 * Created by lucas on 31/10/14.
 */
public class Assembler {

    public void pass_one() {
        //Ess procedimento é um esboço da passagem um para um assembler simples
        boolean more_input = true;                             // sinal que pára a passagem um
        String line, symbol, literal, opcode = null;           // campos da instrução
        int location_counter, length, value, type;             // variaveis diversas
        final int END_STATEMENT = -2;                          // sinaliza final da entrada

        location_counter = 0;                                  // monta a primeira instrução em 0
        initialize_tables();                                   // inicialização geral

        while (more_input) {                                   // more_input ajustada para falso por END
            line = read_next_line();                           // obtenha uma linha de entrada
            length = 0;                                        // # bytes na instrução
            type = 0;                                          // de que tipo(formato) é a instrução

            if (line_is_not_comment(line)) {
                symbol = check_for_symbol(line);               // essa linha é rotulada ?
                if (symbol != null)                            // se for, registre simbolo e valor
                    enter_new_symbol(symbol, location_counter);
                literal = check_for_literal(line);             // a linha contém um literal ?
                if (literal != null)                           // se contiver, entre a linha na tabela
                    enter_new_literal(literal);


                // Agora determine o tipo de opcode -1 significa opcode ilegal
                opcode = extract_opcode(line);                 // localize o mnemônico do opcode
                type = search_opcode_table(opcode);            // ache o formato, por exemplo OP REG1, REG2
                if (type < 0)                                  // se não for um opcode, é uma pseudo-instrução ?
                    type = search_pseuso_table(opcode);
                switch (type) {                                // determine o comprimento dessa instrução
                    case 1: length = get_length_of_type1(line); break;
                    case 2: length = get_length_of_type2(line); break;
                    // outros casos aqui
                }
            }

            write_temp_file(type, opcode, length, line);       // informação util para a passagem dois
            location_counter += length;                        // atualiza location_counter
            if (type == END_STATEMENT) {                       // terminamos a entrada ?
                more_input = false;                            // se terminamos, execute tarefas de preparo
                rewind_temp_for_pass_two();                    // tais como rebobinar o arquivo temporario
                sort_literal_table();                          // e ordenar a tabela de literais
                remove_redundant_literals();                   // e remover literais duplicadas
            }
        }
    }

    public void pass_two() {
        // Esse procedimento é um esboço de passagem dois para um assembler simples
        boolean more_input = true;                             // sinal que pára a passagem dois
        String line, opcode;                                   // campos da instrução
        int location_counter, length, type;                    // variaveis diversas
        final int END_STATEMENT = -2;                          // sinaliza final da entrada
        final int MAX_CODE = 16;                               // máximo de bytes de codigo por instrução
        byte [] code = new byte[MAX_CODE];                     // contém codigo gerado por instrução

        location_counter = 0;                                  // monta a primaira instrução em 0

        while (more_input) {                                   // more_input ajustada para falso por END
            type = read_type();                                // obtém campo de tipo da proxima linha
            opcode = read_opcode();                            // obtém campo de opcode da proxima linha
            length = read_length();                            // obtém comprimento de campo da proxima linha
            line = read_line();                                // obtém a linha de entrada propriamente dita

            if (type != 0 ) {                                  // tipo 0 é para linhas de comentario
                switch (type) {                                // gerar o codigo de saída
                    case 1: eval_type1(opcode, length, line, code); break;
                    case 2: eval_type2(opcode, length, line, code); break;
                    // outros casos aqui
                }
            }

            write_output(code);                                // escreve o código binário
            write_listing(code, line);                         // imprime uma linha na listagem
            location_counter += length;                        // atualiza location_counter
            if (type == END_STATEMENT) {                       // terminamos a entrada ?
                more_input= false;                             // se terminamos, execute tarefas de manutenção
                finish_up();                                   // avulsas
            }
        }
    }

    // UTILIZADOS NA SEGUNDA PASSAGEM

    private void finish_up() {

    }

    private void write_listing(byte[] code, String line) {

    }

    private void write_output(byte[] code) {

    }

    private void eval_type2(String opcode, int length, String line, byte[] code) {

    }

    private void eval_type1(String opcode, int length, String line, byte[] code) {

    }

    private String read_line() {
        return null;
    }

    private int read_length() {
        return 0;
    }

    private String read_opcode() {
        return null;
    }

    private int read_type() {
        return 0;
    }

    // UTILIZADOS NA PRIMEIRA PASSAGEM

    private void remove_redundant_literals() {

    }

    private void sort_literal_table() {

    }

    private void rewind_temp_for_pass_two() {

    }

    private void write_temp_file(int type, String opcode, int length, String line) {

    }

    private int get_length_of_type2(String line) {
        return 0;
    }

    private int get_length_of_type1(String line) {
        return 0;
    }

    private int search_pseuso_table(String opcode) {
        return 0;
    }

    private int search_opcode_table(String opcode) {
        return 0;
    }

    private String extract_opcode(String line) {
        return null;
    }

    private void enter_new_literal(String literal) {

    }

    private String check_for_literal(String line) {
        return null;
    }

    private void enter_new_symbol(String symbol, int location_counter) {

    }

    private String check_for_symbol(String line) {
        return null;
    }

    private boolean line_is_not_comment(String line) {
        return false;
    }

    private String read_next_line() {
        return null;
    }

    private void initialize_tables() {

    }

}
