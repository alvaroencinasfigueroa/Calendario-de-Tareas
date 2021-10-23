package desCalendar.principal;

import descCalendar.vista.Perfil;
import descCalendar.vista.menuLider.*;
import desCalendar.controlador.*;
import descCalendar.modelo.*;
import descCalendar.vista.*;
import javax.swing.UIManager;

public class Main {
    //com.jtattoo.plaf.noire.NoireLookAndFeel
    //com.jtattoo.plaf.luna.LunaLookAndFeel
    //com.jtattoo.plaf.texture.TextureLookAndFeel
    //com.jtattoo.plaf.aluminium.AluminiumLookAndFeel
    //com.jtattoo.plaf.bernstein.BernsteinLookAndFeel
    //com.jtattoo.plaf.mint.MintLookAndFeel
    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        }catch(Exception e){
        }
        
        Logica logica = new Logica();
        //paneles
        MenuInicio menu = new MenuInicio();
        MenuLider pLider = new MenuLider();
        Perfil pPerfil = new Perfil();
        EditarGrupo pEditGrupo = new EditarGrupo();
        CrearTarea pCrearTarea = new CrearTarea();
        EditarTarea pEditarTarea = new EditarTarea();
        TareasPendientes pTareasP = new TareasPendientes();
        TareasRealizadas pTareasRea = new TareasRealizadas();
        MostrarMiembros pMostrarMiembros = new MostrarMiembros();
        MenuMiembroSG pMenuMiembroSG = new MenuMiembroSG();
        

        MenuMiembro pMiembro = new MenuMiembro();
        Registro form = new Registro();
        Acceder acceder = new Acceder();
        Creditos creditos = new Creditos();
        MostrarGrupos pMosGrupos = new MostrarGrupos();
        Invitar pInvitar = new Invitar();
        

        Coordinador coordinador = new Coordinador();
        //ventana principal
        Principal ventanaPrincipal = new Principal();

        pLider.setCoordinador(coordinador);
        pPerfil.setCoordinador(coordinador);
        pEditGrupo.setCoordinador(coordinador);
        pMiembro.setCoordinador(coordinador);
        menu.setCoordinador(coordinador);
        form.setCoordinador(coordinador);
        acceder.setCoordinador(coordinador);
        ventanaPrincipal.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        pMosGrupos.setCoordinador(coordinador);
        pInvitar.setCoordinador(coordinador);
        pCrearTarea.setCoordinador(coordinador);
        pEditarTarea.setCoordinador(coordinador);
        pTareasP.setCoordinador(coordinador);
        pTareasRea.setCoordinador(coordinador);
        pMostrarMiembros.setCoordinador(coordinador);
        pMenuMiembroSG.setCoordinador(coordinador);
        creditos.setCoordinador(coordinador);

        coordinador.setMenuLider(pLider);
        coordinador.setPerfil(pPerfil);
        coordinador.setPEditGrupo(pEditGrupo);
        coordinador.setMenuMiembro(pMiembro);
        coordinador.setMenu(menu);
        coordinador.setAcceder(acceder);
        coordinador.setRegistro(form);
        coordinador.setCreditos(creditos);
        coordinador.setVentanaPrincipal(ventanaPrincipal);
        coordinador.setMosGrupos(pMosGrupos);
        coordinador.setInvitar(pInvitar);
        coordinador.setCrearTarea(pCrearTarea);
        coordinador.setEditarTarea(pEditarTarea);
        coordinador.setTPendientes(pTareasP);
        coordinador.setTRealizadas(pTareasRea);
        coordinador.setMostrarMiembros(pMostrarMiembros);
        coordinador.setMenuMiembroSG(pMenuMiembroSG);
        coordinador.setLogica(logica);
        
        coordinador.cargarPanel(1, null);
        ventanaPrincipal.setVisible(true);
    }

    
}
