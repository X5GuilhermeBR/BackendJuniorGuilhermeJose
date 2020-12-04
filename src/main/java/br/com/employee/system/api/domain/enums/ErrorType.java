package br.com.employee.system.api.domain.enums;

public enum ErrorType {

    DUPLICATED_CPF(422001, "Um usuário com o mesmo CPF já existe no sistema."),
    NULLABLE_REQUEST(422002, "O corpo da requisição está nulo ou em formato inválido."),
    DUPLICATED_EMAIL(422003, "Um usuário com o mesmo e-mail já existe no sistema."),
    WRONG_CPF(422004, "CPF inválido."),
    LIMIT_AGE_REACHED(422004, "Limite de funcionários com idade menor de 18 ou maior de 65 atingido."),
    USER_BANNED(422005, "Não é possível prosseguir com o registro do usuário. O mesmo se encontra na BlackList"),
    REQUIRED_FEATURE_NAME(422012, "O nome da Funcionalidade é obrigaória."),
    APPLICATION_NOT_FOUNDED(403001, "Credenciais de aplicação para acesso ao recurso inválidas."),
    PROFILE_FEATURE_NOT_FOUNDED(404006, "Perfil ou funcionalidade não encontrada no sistema."),
    PROFILE_NOT_FOUNDED(404002, "Perfil não encontrado no sistema"),
    PROFILE_VISIBILITY_NOT_FOUNDED(404003, "Perfil ou visibildade não encontrada no sistema"),
    RESOURCE_NOT_FOUNDED(404007, "Recurso não encontrada no sistema."),
    USER_NOT_FOUNDED(404004, "Usuário não encontrado no sistema"),
    USER_VISIBILITY_NOT_FOUNDED(404005, "Usuário ou visibilidade não encontrada no sistema"),
    VISIBILITY_NOT_FOUNDED(404001, "Visibilidade não encontrada no sistema."),
    REQUIRED_RESOURCE_NAME(422013, "O nome do Recurso é obrigaória."),
    DUPLICATED_RESOURCE_NAME(422014, "Um Recurso com o mesmo nome já existe no sistema."),
    PROFILE_RESOURCE_NOT_FOUNDED(404008, "Perfil ou Recurso não encontrada no sistema."),
    REQUIRED_RESOURCE_DESCRIPTION(422015, "A descrição do Recurso é obrigatória."),
    INTERNAL_SERVER_ERROR(500001,
                                  "Ocorreu um erro interno ao servidor, tente novamente ou entre em contato com o suporte técnico."),
    FEATURE_NOT_FOUNDED(404009, "Funcionalidade não encontrada no sistema.");

    private final int code;
    private final String message;

    ErrorType(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
