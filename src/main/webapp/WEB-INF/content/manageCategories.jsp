<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 22.07.2017
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <%--<legend>Source address</legend>--%>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Country">Country</label>
            <div class="col-md-5">
                <select id="Country" name="Country" class="form-control">
                    <option value="DE">Germany</option>
                    <option value="Ru">Russia</option>
                    <option value="USA">United States</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="State">Region/State</label>
            <div class="col-md-5">
                <select id="State" name="State" class="form-control">
                    <option value="1">Berlin</option>
                    <option value="2">Moscow</option>
                    <option value="3">Washington</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="city">City/Town</label>
            <div class="col-md-6">
                <input id="city" name="city" type="text" placeholder="city or town" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="address1">Address Line1</label>
            <div class="col-md-8">
                <input id="address1" name="address1" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Street address, P.O. box, company name, c/o</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="zip">Zip/Postal code</label>
            <div class="col-md-4">
                <input id="zip" name="zip" type="text" placeholder="zip or postal code" class="form-control input-md" required="">

            </div>
        </div>



        <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
                <input class="btn btn-primary" value="Save Changes" type="submit">
                <span></span>
                <input class="btn btn-default" value="Cancel" type="reset">
            </div>
        </div>

    </fieldset>
</form>
