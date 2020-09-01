package br.com.exame.dao;

import br.com.exame.ws.client.Exame;
import java.util.List;

public interface ExameDAO
{

    public abstract boolean salva(Exame exame);

    public abstract boolean remove(Exame exame);

    public abstract boolean altera(Exame exame);

    public abstract List<Exame> lista();
}