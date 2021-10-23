/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desCalendar.controlador;

import descCalendar.vista.Perfil;
import descCalendar.vista.menuLider.*;
import descCalendar.modelo.*;
import descCalendar.vista.*;

/**
 *
 * 
 */
public class Coordinador {

    private Logica logica;
    
    private MenuInicio menu;
    private MenuLider pLider;
    private Creditos creditos;
    private Invitar pInvitar;
    private CrearTarea pCrearTarea;
    private EditarTarea pEditarTarea;
    private EditarGrupo pEditGrupo;
    private Perfil pPerfil;
    private MenuMiembro pMiembro;
    private Acceder pAcceder;
    private Registro pRegistro;
    private Principal ventanaPrincipal;
    private MostrarGrupos pMosGrupos;
    private TareasPendientes pTareasPendientes;
    private TareasRealizadas pTareasRealizadas;
    private MostrarMiembros pMostrarMiembros;
    private MenuMiembroSG pMenuMiembroSG;
    

    public void cargarPanel(int i,Usuario l) {
        menu.setVisible(false);
        pLider.setVisible(false);
        pMiembro.setVisible(false);
        pAcceder.setVisible(false);
        pRegistro.setVisible(false);
        pMosGrupos.setVisible(false);
        pPerfil.setVisible(false);
        pInvitar.setVisible(false);
        pEditGrupo.setVisible(false);
        pCrearTarea.setVisible(false);
        pEditarTarea.setVisible(false);
        pTareasPendientes.setVisible(false);
        pTareasRealizadas.setVisible(false);
        pMostrarMiembros.setVisible(false);
        pMenuMiembroSG.setVisible(false);
        creditos.setVisible(false);
        switch (i) {
            case 1:
                menu.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(menu);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 2:
                pRegistro.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pRegistro);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 3:
                pAcceder.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pAcceder);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 4:
                pLider.setLider(l);
                pLider.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pLider);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 5:
                pMiembro.setMiembro(l);
                pMiembro.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pMiembro);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 6:
                pMosGrupos.actualizarLNombresGrupos(this);
                pMosGrupos.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pMosGrupos);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 7:
                pPerfil.setUsuario(l);
                pPerfil.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pPerfil);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 8:
                pInvitar.setLider(l);
                pInvitar.llenarJListMiembros(this);
                pInvitar.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pInvitar);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 9:
                pEditGrupo.setLider(l);
                pEditGrupo.reinicio();
                pEditGrupo.llenarJListMiembros(this, l);
                pEditGrupo.llenarJCBLider(this, l);
                pEditGrupo.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pEditGrupo);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 10:
                pTareasPendientes.setUsuario(l);
                pTareasPendientes.setVisible(true);
                pTareasPendientes.reinicio();
                ventanaPrincipal.getJPContenedor().add(pTareasPendientes);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 11:
                pCrearTarea.setLider(l);
                pCrearTarea.llenarJListMiembros(this,l);
                pCrearTarea.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pCrearTarea);
                ventanaPrincipal.getJPContenedor().validate();
                break;  
            case 12:
                pTareasRealizadas.setUsuario(l);
                pTareasRealizadas.setVisible(true);
                pTareasRealizadas.actualizarListTareasRea();
                pTareasRealizadas.reinicio();
                ventanaPrincipal.getJPContenedor().add(pTareasRealizadas);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 13:
                pMostrarMiembros.setUsuario(l);
                pMostrarMiembros.llenarJListMiembros(this, l);
                pMostrarMiembros.setVisible(true);
                pMostrarMiembros.actualizar();
                pMostrarMiembros.vaciarDetMiembro();
                ventanaPrincipal.getJPContenedor().add(pMostrarMiembros);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 14:
                pEditarTarea.setLider(l);
                pEditarTarea.llenarJListMiembros(this,l);
                pEditarTarea.setVisible(true);
                pEditarTarea.llenarJCBTarea(this, l);
                ventanaPrincipal.getJPContenedor().add(pEditarTarea);
                ventanaPrincipal.getJPContenedor().validate();
                break; 
            case 15:
                pMenuMiembroSG.setMiembro(l);
                pMenuMiembroSG.reinicio();
                pMenuMiembroSG.llenarJCBInvitaciones(this,l);
                pMenuMiembroSG.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(pMenuMiembroSG);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            case 16:
                creditos.setVisible(true);
                ventanaPrincipal.getJPContenedor().add(creditos);
                ventanaPrincipal.getJPContenedor().validate();
                break;
            default:
                break;
        }
    }

    public void setRegistro(Registro form) {
        pRegistro = form;
    }

    public Registro getRegistro() {
        return pRegistro;
    }

    public void setVentanaPrincipal(Principal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public Principal getVentanaPrincipal(Principal ventanaPrincipal) {
        return ventanaPrincipal;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public Logica getLogica() {
        return logica;
    }

    public void setAcceder(Acceder acceder) {
        pAcceder = acceder;
    }

    public void setMenu(MenuInicio m) {
        menu = m;
    }

    public void setMenuLider(MenuLider pLider) {
        this.pLider = pLider;
    }

    public void setMenuMiembro(MenuMiembro pMiembro) {
        this.pMiembro = pMiembro;
    }
    
    public void setMosGrupos(MostrarGrupos pMosGrupos) {
        this.pMosGrupos = pMosGrupos;
    }

    public void setPerfil(Perfil pPerfil) {
        this.pPerfil = pPerfil;
    }

    public void setInvitar(Invitar pInvitar) {
        this.pInvitar = pInvitar;
    }

    public void setPEditGrupo(EditarGrupo pEditGrupo) {
        this.pEditGrupo = pEditGrupo;
    }

    public void setTPendientes(TareasPendientes pTPend) {
        this.pTareasPendientes = pTPend;
    }

    public void setTRealizadas(TareasRealizadas pTRea) {
        this.pTareasRealizadas = pTRea;
    }
    
    public void setCrearTarea(CrearTarea pCrearTarea) {
        this.pCrearTarea = pCrearTarea;
    }
    
    public void setMostrarMiembros(MostrarMiembros pMostrarMiembros) {
        this.pMostrarMiembros = pMostrarMiembros;
    }

    public void setEditarTarea(EditarTarea pEditarTarea) {
        this.pEditarTarea = pEditarTarea;
    }

    public void setMenuMiembroSG(MenuMiembroSG pMenuMiembroSG) {
        this.pMenuMiembroSG = pMenuMiembroSG;
    }
    public void setCreditos(Creditos creditos){
        this.creditos = creditos;
    }
    public Creditos getCreditos(){
        return creditos;
    }
}
