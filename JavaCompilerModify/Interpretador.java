class Interpretador{

    int executa (ArvoreSintatica arv)
	{
		return (calcula(arv));
	}

	int calcula (ArvoreSintatica arv)
	{

        if (arv instanceof Mult)
		    return (calcula(((Mult) arv).arg1) * calcula(((Mult) arv).arg2));

        if (arv instanceof Div)
		    return (calcula(((Div) arv).arg1) / calcula(((Div) arv).arg2));

        if (arv instanceof Soma)
		    return (calcula(((Soma) arv).arg1) + calcula(((Soma) arv).arg2));

        if (arv instanceof Sub)
		    return (calcula(((Sub) arv).arg1) - calcula(((Sub) arv).arg2));

	    if (arv instanceof Num)
		    return (((Num) arv).num);

        return 0;
	}
	
}

