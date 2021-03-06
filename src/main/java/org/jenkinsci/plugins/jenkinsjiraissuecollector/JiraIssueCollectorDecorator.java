/**
        The MIT License

        Copyright (c) 2016, Orian Beltrame

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in
        all copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
        THE SOFTWARE.
*/

package org.jenkinsci.plugins.jenkinsjiraissuecollector;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Util;
import hudson.model.PageDecorator;

@Extension
public class JiraIssueCollectorDecorator extends PageDecorator {

    private String issueCollectorURL;

    @DataBoundConstructor
    public JiraIssueCollectorDecorator(String issueCollectorURL) {
        this();
        this.issueCollectorURL = issueCollectorURL;
    }

    public JiraIssueCollectorDecorator() {
        super(JiraIssueCollectorDecorator.class);
        load();
    }

    @Override
    public String getDisplayName() {
        return "Jira Issue Collector";
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return true;
    }

    public String getIssueCollectorURL() {
        return Util.fixEmpty(issueCollectorURL);
    }

    public void setIssueCollectorURL(String issueCollectorURL) {
        this.issueCollectorURL = issueCollectorURL;
    }

}
