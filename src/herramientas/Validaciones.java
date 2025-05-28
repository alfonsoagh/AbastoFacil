/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Clase para llevar a cabo validaciones simples en cajas de texto en un
 * ambiente de pantallas de java
 *
 * @author Lenovo
 */
public class Validaciones
{

    public static void validaAlfaNum(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            char validar = ke.getKeyChar();

            if (ke.getKeyChar() == ' ')
            {
                if (s.length() != 0)
                {

                } else
                {
                    ke.consume();
                }
            } else
            {
                if (!Character.isLetter((validar)))
                {
                    if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                            && ke.getKeyCode() != 8)
                    {
                        ke.setKeyChar((char) 8);
                    }
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaEntero(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8)
        {
            ke.setKeyChar((char) 8);
        }
    }

    public static boolean validaEntero(KeyEvent ke, String s)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8)
        {
            return true;
        }
        {
            ke.setKeyChar((char) 8);
        }
        return false;
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero, de no ser así lo elimina, validando la longitud maxima de la
     * misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaEntero(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8)
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero o entero negativo, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaEnteroNegativo(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '-')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero o entero negativo, de no ser así lo elimina, validando la longitud
     * maxima de la misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaEnteroNegativo(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '-')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaFlotantes(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '.')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante, de no ser así lo elimina, validando la
     * longitud maxima de la misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaFlotantes(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '.')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * caracter alfabético, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaAlfabeticos(KeyEvent ke)
    {
        va(ke);
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * caracter alfabético, de no ser así lo elimina, ademas verifica la logitud
     * máxima permitida en dicha caja de texto
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud máxima que se permitira capturar en la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaAlfabeticos(KeyEvent ke, int len, String s)
    {
        char inputChar = ke.getKeyChar();
        if (s.length() == len || (s.length() == 0 && inputChar == ' '))
        {
            ke.consume();
        } else
        {
            va(ke);
        }
    }

    public static void validaAlfabeticosM(KeyEvent ke, int len, String s)
    {
        if (s.length() == len || (s.length() == 0 && ke.getKeyChar() == ' '))
        {
            ke.consume();
        } else
        {
            if (s.equals(""))
            {
                if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
                {
                    ke.setKeyChar((char) (ke.getKeyChar() - 32));
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * alfanumérico, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaAlfanumerico(KeyEvent ke)
    {
        vanM(ke);
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * alfanumérico, de no ser así lo elimina y verifica la longitud maxima de
     * caracteres que se pueden capturar en la caja
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud máxima que se permitira capturar en la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaAlfanumerico(KeyEvent ke, int len, String s)
    {
        if (s.length() == len || ke.getKeyChar() == ' ')
        {
            ke.consume();
        } else
        {
            vanM(ke);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de verificar si el contenido de la misma es entero
     *
     * @param jt Caja de texto a evaluar
     * @return verdadero si el contenido de la caja es un entero y false si el
     * contenido de la misma no es un entero
     */
    public static boolean verificaEntero(JTextField jt)
    {
        try
        {
            int x = Integer.parseInt(jt.getText());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de verificar si el contenido de la misma es un número con punto
     * flotante
     *
     * @param jt Caja de texto a evaluar
     * @return verdadero si el contenido de la caja es un un número con punto
     * flotante y false si el contenido de la misma no lo es
     */
    public static boolean verificaDoble(JTextField jt)
    {
        try
        {
            double x = Double.parseDouble(jt.getText());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            CtrlInterfaz.cambia(obj);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena convirtiendo su contenido a
     * mayusculas y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se desea pasar a mayusculas o "" si no desea
     * pasar nada a mayusculas
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj, JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (!jt.getText().equals(""))
            {
                jt.setText(jt.getText().toUpperCase());
            }
            CtrlInterfaz.cambia(obj);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto pero
     * si esta vacia marca error y no permite el cambio
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se verifica que no este vacia
     * @param s texto que desea aparezca como mensaje de error
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj, JTextField jt, String s)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (!jt.getText().equals(""))
            {
                CtrlInterfaz.cambia(obj);
            } else
            {
                Mensaje.error(jf, s);
                CtrlInterfaz.cambia(jt);
            }

        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterEntero(JFrame jf, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (verificaEntero(jt))
            {
                CtrlInterfaz.cambia(obj);
            } else
            {
                Mensaje.error(jf, "Se esperaba un entero");
                CtrlInterfaz.selecciona(jt);
            }

        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un valor flotante y cambia a otro
     * objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterFlotante(JFrame jf, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (verificaDoble(jt))
            {
                CtrlInterfaz.cambia(obj);
            } else
            {
                Mensaje.error(jf, "Se esperaba un flotante");
                CtrlInterfaz.selecciona(jt);
            }

        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enter(JDialog jd, KeyEvent ke, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            CtrlInterfaz.cambia(obj);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se desea pasar a mayusculas o "" si no desea
     * pasar nada a mayusculas
     */
    public static void enter(JDialog jd, KeyEvent ke, Object obj, JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (!jt.getText().equals(""))
            {
                jt.setText(jt.getText().toUpperCase());
            }
            CtrlInterfaz.cambia(obj);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterEntero(JDialog jd, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (verificaEntero(jt))
            {
                CtrlInterfaz.cambia(obj);
            } else
            {
                Mensaje.error(jd, "Se esperaba un entero");
                CtrlInterfaz.selecciona(jt);
            }

        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un valor flotante y cambia a otro
     * objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterFlotante(JDialog jd, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (verificaDoble(jt))
            {
                CtrlInterfaz.cambia(obj);
            } else
            {
                Mensaje.error(jd, "Se esperaba un flotante");
                CtrlInterfaz.selecciona(jt);
            }

        }
    }

    /**
     * Metodo privado para validar alfabeticos
     *
     * @param ke
     */
    private static void va(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != ' '
                && ke.getKeyChar() != 'ñ' && ke.getKeyChar() != 'Ñ'
                && ke.getKeyChar() != 'á' && ke.getKeyChar() != 'Á'
                && ke.getKeyChar() != 'é' && ke.getKeyChar() != 'É'
                && ke.getKeyChar() != 'í' && ke.getKeyChar() != 'Í'
                && ke.getKeyChar() != 'ó' && ke.getKeyChar() != 'Ó'
                && ke.getKeyChar() != 'ú' && ke.getKeyChar() != 'Ú')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método privado para validar alfanumericos
     *
     * @param ke
     */
    private static void van(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
        {
            ke.setKeyChar((char) 8);
        }
    }

    private static void vanM(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
        {
            ke.setKeyChar((char) 8);
        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
        {
            ke.setKeyChar((char) (ke.getKeyChar() - 32));
        }
    }

    private static void vaM(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z'))
        {
            ke.setKeyChar((char) 8);
        } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
        {
            ke.setKeyChar((char) (ke.getKeyChar() - 32));
        }
    }

    public static void deshabilitar(JComponent campo)
    {
        campo.getInputMap().put(KeyStroke.getKeyStroke("control c"), "null");
        campo.getInputMap().put(KeyStroke.getKeyStroke("control x"), "null");
        campo.getInputMap().put(KeyStroke.getKeyStroke("control v"), "null");
        campo.getInputMap().put(KeyStroke.getKeyStroke("shift INSERT"), "null");
    }

    public static String mayusculas(String s, KeyEvent ke)
    {
        s = s.toUpperCase();
        ke.setKeyChar((char) 8);
        return s;
    }

    public static void validaLetra(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            char validar = ke.getKeyChar();
            if (ke.getKeyChar() == ' ')
            {

            } else
            {
                if (!Character.isLetter((validar)))
                {
                    ke.consume();
                }
            }
        }
    }

    public static void va(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != ' '
                    && ke.getKeyChar() != 'ñ' && ke.getKeyChar() != 'Ñ'
                    && ke.getKeyChar() != 'á' && ke.getKeyChar() != 'Á'
                    && ke.getKeyChar() != 'é' && ke.getKeyChar() != 'É'
                    && ke.getKeyChar() != 'í' && ke.getKeyChar() != 'Í'
                    && ke.getKeyChar() != 'ó' && ke.getKeyChar() != 'Ó'
                    && ke.getKeyChar() != 'ú' && ke.getKeyChar() != 'Ú')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    public static void vaP(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '-'
                    && ke.getKeyChar() != 'ñ' && ke.getKeyChar() != 'Ñ'
                    && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    public static void inhabilitaPegar(JComponent... campos)
    {
        for (JComponent campo : campos)
        {
            InputMap map = campo.getInputMap();
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
            map.put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, Event.SHIFT_MASK), "null");
        }
    }

    public static void vaM(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z'))
            {
                ke.setKeyChar((char) 8);
            } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
            {
                ke.setKeyChar((char) (ke.getKeyChar() - 32));
            } else if (ke.getKeyChar() == 'ñ')
            {
                ke.setKeyChar('Ñ');
            } else if (ke.getKeyChar() == 'á')
            {
                ke.setKeyChar('Á');
            } else if (ke.getKeyChar() == 'é')
            {
                ke.setKeyChar('É');
            } else if (ke.getKeyChar() == 'í')
            {
                ke.setKeyChar('Í');
            } else if (ke.getKeyChar() == 'ó')
            {
                ke.setKeyChar('Ó');
            } else if (ke.getKeyChar() == 'ú')
            {
                ke.setKeyChar('Ú');
            }
        }
    }

    public static void validaPrecios(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {

            boolean puntoDecimalIngresado = (ke.getKeyChar() == '.');

            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9') && !puntoDecimalIngresado && ke.getKeyCode() != 8)
            {
                ke.consume();
            } else
            {

                if (s.contains(".") && puntoDecimalIngresado)
                {
                    ke.consume();
                }
            }
        }

    }

    public static void validaRFC(KeyEvent ke, String s)
    {
        if (s.length() == 13)
        {
            ke.consume();
        } else
        {
            if (s.length() <= 3)
            {
                vaM(ke);
            }
            if (s.length() >= 4 && s.length() < 10)
            {
                validaEntero(ke);
            }
            if (s.length() >= 10)
            {
                validaAlfanumerico(ke);
            }
        }
    }
}
