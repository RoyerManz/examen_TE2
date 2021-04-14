package com.emergentes;

import java.util.ArrayList;

public class RegistroDAO {
    private int correlativo;
    private ArrayList<Registro> Registros;

    public RegistroDAO() {
        Registros = new ArrayList<Registro>();
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public ArrayList<Registro> getRegistros() {
        return Registros;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public void setRegistros(ArrayList<Registro> Registros) {
        this.Registros = Registros;
    }
    
    public void insertar(Registro item){
        Registros.add(item);
    }
    
    public int posicion(int id){
        int i=-1;
        if(Registros.size()>0){
            for(Registro item: Registros){
                ++i;
                if(item.getId()==id){
                    break;
                }
            }
        }
        return i;
    }
    
    public void eliminar(int id){
        int pos=posicion(id);
        Registros.remove(pos);
    }
    
    public void modificar(int id,Registro item){
        int pos=posicion(id);
        Registros.set(pos, item);
    }
    
}
