package org.hackatonalm.dignificame;

import org.hackatonalm.dignificame.models.Denuncia;
import org.hackatonalm.dignificame.models.Empresa;
import org.hackatonalm.dignificame.models.Oferta;

import java.util.HashMap;

/**
 * Created by Arasthel on 23/03/14.
 */
public class DataStorage {

    public static HashMap<String, Empresa> ofertasMap = new HashMap<String, Empresa>();
    public static Oferta currentOferta;
    public static Denuncia currentDenuncia;
    public static Empresa currentEmpresa;

}
