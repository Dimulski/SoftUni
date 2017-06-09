function expressionSplit(expression) {
    return expression.split(/[\s.();,]+/).join('\n');
}