package org.jacorb.notification.engine;

/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1999-2004 Gerald Brose
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */

import org.jacorb.notification.util.AbstractObjectPool;
import org.jacorb.notification.util.AbstractPoolable;

/**
 * @author Alphonse Bendt
 * @version $Id$
 */

public abstract class AbstractPoolablePool extends AbstractObjectPool
{
    public AbstractPoolablePool(String name, int threshold, int increase, int initial, int maxsize) {
        super(name, threshold, increase, initial, maxsize);
    }


    public AbstractPoolablePool(String name) {
        super(name);
    }

    
    public void passivateObject( Object o )
    {
        ( ( AbstractPoolable ) o ).reset();
    }


    public void activateObject( Object o )
    {
        ( ( AbstractPoolable ) o ).setObjectPool( this );
    }
}